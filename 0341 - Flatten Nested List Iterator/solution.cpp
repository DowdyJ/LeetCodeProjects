const static auto uwu = [] { std::ios_base::sync_with_stdio(false); std::cout.tie(nullptr); std::cin.tie(nullptr); return nullptr;}();

class NestedIterator {
public:
    NestedIterator(vector<NestedInteger> &nestedList) {
        this->nestedList = nestedList;
    }

    ~NestedIterator() {
        delete innerList;
        innerList = nullptr;
    }
    
    int next() {
        if (this->nestedList[curIndex].isInteger()) {
            return this->nestedList[curIndex++].getInteger();
        }

        if (this->innerList->hasNext()) {
            return this->innerList->next();
        }
        else {
            delete this->innerList;
            this->innerList = nullptr;
            this->curIndex++;
            return this->next();
        }
    }
    
    bool hasNext() {
        if (this->nestedList.size() == 0 || this->curIndex >= this->nestedList.size()) {
            return false;
        }

        if (!this->nestedList[curIndex].isInteger()) {
            if (this->innerList == nullptr) {
                this->innerList = new NestedIterator(this->nestedList[curIndex].getList());
            }

            if (this->innerList->hasNext()) {
                return true;
            }
            else {
                delete this->innerList;
                this->innerList = nullptr;
                curIndex++;
                return this->hasNext();
            }
        }

        if (this->innerList != nullptr) {
            return this->innerList->hasNext() || this->curIndex < this->nestedList.size() - 1;
        } 
        else {
            return this->curIndex < this->nestedList.size();
        }
    }


private:
    int curIndex = 0;
    vector<NestedInteger> nestedList;
    NestedIterator* innerList = nullptr;
};

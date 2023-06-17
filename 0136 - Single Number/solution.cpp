#include <iostream>
#include <vector>
#include <unordered_set>

using std::vector;
using std::unordered_set;
using std::cout;
using std::endl;

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        unordered_set<int> seenNumbers;

        for (const int& num : nums) {
            if (seenNumbers.find(num) != seenNumbers.end()) {
                seenNumbers.erase(num);
            }
            else {
                seenNumbers.emplace(num);
            }
        }

        return *(seenNumbers.begin());
    }
};

int main() {
    vector<int> nums = {1};
    Solution s;
    cout << s.singleNumber(nums) << endl;
    
    return 0;
}
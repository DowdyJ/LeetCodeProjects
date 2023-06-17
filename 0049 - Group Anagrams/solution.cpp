
#include <vector>
#include <string>
#include <map>
#include <iostream>

using std::vector;
using std::string;
using std::map;




class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {

        vector<vector<string>> result = vector<vector<string>>();

        if (strs.size() == 0)
            return result;

        vector<string> cachedStrings(strs);

        map<string, vector<int>> groupDictionary = map<string, vector<int>>();

        for (int i = 0; i < strs.size(); ++i) {
            quicksort(strs[i], 0, strs[i].length() - 1);

            if (groupDictionary.count(strs[i]) == 0) {
                groupDictionary[strs[i]] = vector<int>();
            }

            groupDictionary[strs[i]].push_back(i);
        }

        int resultIndex = 0;
        for (auto entry : groupDictionary) {
            result.push_back(vector<string>());

            for (int i = 0; i < entry.second.size(); ++i) {
                result[resultIndex].push_back(cachedStrings[entry.second[i]]);
            }

            resultIndex++;
        }

        return result;
    }

private:
    void swap(string& string, int i, int j) {
        char temp = string[i];
        string[i] = string[j];
        string[j] = temp;
    }


    void partition(string& string, int low, int high, int* left, int* right) {
        *right = high;
        int mid = low;
        char pivot = string[high];

        while (mid <= *right) {
            if (string[mid] < pivot) {
                swap(string, low++, mid++);
            } 
            else if (string[mid] > pivot) {
                swap(string, mid, (*right)--);
            } 
            else {
                mid++;
            }
        }

        *left = low-1;
        *right = mid;
    }

    void quicksort(string& string, int low, int high) {

        if (high < low)
            return;

        int left, right;

        partition(string, low, high, &left, &right);

        quicksort(string, low, left);
        quicksort(string, right, high);
    }
};

//["eat","tea","tan","ate","nat","bat"]

int main() {
    Solution s = Solution();

    vector<string> input = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
    auto res = s.groupAnagrams(input);

    for (auto vec : res) {
        for (auto s : vec) {
            std::cout << s << ", ";
        }
        std::cout << std::endl;
    }

    return 0;
}
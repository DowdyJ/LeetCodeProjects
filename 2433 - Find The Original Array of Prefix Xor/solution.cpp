#include <vector>
#include <iostream>

using std::cout;
using std::endl;
using std::vector;

const static auto initialize = [] { std::ios::sync_with_stdio(false); std::cin.tie(nullptr); std::cout.tie(nullptr); return nullptr; }();

class Solution {
public:
    vector<int> findArray(vector<int>& pref) {
        for (int j = 1; j < pref.size(); ++j)
            pref[j] = pref[j] ^ pref[j-1];

        return pref;
    }
};

int main() {
    Solution s;
    vector<int> nums = vector<int> {5};
    for (const int& num : s.findArray(nums))
        cout << num << ", ";

    cout << endl;
    return 0;
}
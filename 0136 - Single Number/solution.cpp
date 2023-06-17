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
        int result = 0;

        for (const int& num : nums)
            result ^= num;

        return result;
    }
};

int main() {
    vector<int> nums = {1};
    Solution s;
    cout << s.singleNumber(nums) << endl;

    return 0;
}
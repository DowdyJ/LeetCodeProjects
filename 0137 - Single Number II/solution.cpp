#include <vector>
#include <unordered_set>
#include <algorithm>

using std::unordered_set;
using std::vector;


class Solution {
public:
    int singleNumber(vector<int>& nums) {
        std::sort(nums.begin(), nums.end());

        for (int i = 0; i + 2 < nums.size(); i += 3) {
            if (nums[i] != nums[i +1]) {
                return nums[i];
            }
        }

        return *(nums.end());
    }
};
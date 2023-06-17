#include <vector>
#include <unordered_set>
#include <algorithm>

using std::unordered_set;
using std::vector;


class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        std::sort(nums.begin(), nums.end());
        vector<int> res;
        for (int i = 0; i + 1 < nums.size(); i += 2) {
            if (nums[i] != nums[i +1]) {
                res.push_back(nums[i]);
                if (res.size() == 2)
                    return res;

                i--;
            }
        }

        if (res.size() == 1)
            res.push_back(*--nums.end());

        return res;
    }
};
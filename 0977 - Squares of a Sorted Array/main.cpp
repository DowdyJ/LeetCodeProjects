#include <vector>
#include <algorithm>
#include <iostream>

using std::vector;

class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        struct { bool operator()(int a, int b) const { return std::abs(a) < std::abs(b); } } absSort;
        std::sort(nums.begin(), nums.end(), absSort);
        for (size_t i = 0; i < nums.size(); ++i) { nums[i] *= nums[i]; }
        return nums;
    }
};

int main(int argc, char* argv[]) 
{
    std::cout << "Hello world!" << std::endl;
}
#include <iostream>
#include <vector>

const static auto uwu = [] { std::ios_base::sync_with_stdio(false); std::cout.tie(nullptr); std::cin.tie(nullptr); return nullptr;}();

class Solution {
public:
    int binaryGap(int n) {
        int gap = 0;

        for (int i = 0; i < 32; ++i) {
            if ((n >> i) & 1) {
                for (int j = i + 1; j < 32; ++j) {
                    if ((n >> j) & 1) {
                        gap = gap > j - i ? gap : j - i;
                        break;
                    }
                }
            }
        }

        return gap;
    }
};
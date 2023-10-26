#include <math.h>
#include <iostream>
#include <cmath>

class Solution {
public:
    int kthGrammar(int n, int k) {
        if (n == 1)
            return 0;

        double targetValue = k / pow(2, n-1);

        double upperBound = 1;
        double lowerBound = 0;

        bool result = false;
        int i = 1;
        while ((std::fabs(upperBound - targetValue) > 0.00001 && std::fabs(lowerBound - targetValue) > 0.00001) || i < n) {
            
            if (targetValue == upperBound || targetValue > lowerBound + (upperBound - lowerBound) / 2) { // Go right
                result = !result;
                lowerBound = lowerBound + (upperBound - lowerBound) / 2;
            }
            else { // Go left
                upperBound = lowerBound + (upperBound - lowerBound) / 2;
            }
            ++i;
        }

        return result ? 1 : 0;
    }
};

int main(int argc,char* argv[]) {
    Solution s = Solution();
    
    std::cout << s.kthGrammar(std::atoi(argv[1]), std::atoi(argv[2])) << std::endl;
}

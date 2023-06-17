#include <vector>
#include <iostream>

using std::cout;
using std::endl;
using std::vector;

const static auto uwu = [] { std::ios::sync_with_stdio(false); std::cin.tie(nullptr); std::cout.tie(nullptr); return nullptr; }();

class Solution {
public:
    vector<int> decode(vector<int>& encoded, int first) {
        vector<int> result = vector<int>(encoded.size() + 1, 0);
        result[0] = first;

        for (int i = 1; i < result.size(); ++i) {
            result[i] = encoded[i-1] ^ result[i-1];
        }

        return result;
    }
};

int main() {
    
    return 0;
}
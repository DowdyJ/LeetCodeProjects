#include <vector>
#include <iostream>

using std::cout;
using std::endl;
using std::vector;

const static auto uwu = [] { std::ios::sync_with_stdio(false); std::cin.tie(nullptr); std::cout.tie(nullptr); return nullptr; }();

class Solution {
public:
    vector<int> decode(vector<int>& encoded, int first) {
        encoded.insert(encoded.begin(), first);

        for (int i = 1; i < encoded.size(); ++i) {
            encoded[i] = encoded[i-1] ^ encoded[i];
        }

        return encoded;
    }
};

int main() {
    
    return 0;
}
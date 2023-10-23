class Solution {
public:
    bool isPowerOfFour(int n) {
        return n == 0x1 || n == 0x4 || n == 0x10 || n == 0x40 || n == 0x100 || n == 0x400 || n == 0x1000 || n == 0x4000 || n == 0x10000 || n == 0x40000 || n == 0x100000 || n == 0x400000 || n == 0x1000000 || n == 0x4000000 || n == 0x10000000 || n == 0x40000000;
    }


    bool isPowerOfFourProgramatic(int n) {
        // Bits never found in powers of four
        if (n & ~0x55555555) {
            return false;
        }

        int i = 0;
        bool found = false;
        while (i < 16) {
            if ((1 << 2*i) & n) {
                if (found) {
                    return false;
                }
                else {
                    found = true;
                }
            }
            ++i;
        }

        return found;
    }
};

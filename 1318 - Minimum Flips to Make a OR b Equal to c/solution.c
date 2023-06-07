#include <stdio.h>

int minFlips(int a, int b, int c){
    int combo = a | b;
    int flippedBitCount = 0;
    
    for (int i = 0; i < 32; ++i) {
        if (!(((combo >> i) & 0x1) ^ ((c >> i) & 0x1))) {
            continue;
        } 
        else {
            if (((c >> i) & 0x1) != 0) {
                a |= (i << 0x1);
                ++flippedBitCount;
            } 
            else {
                if ((a >> i) & 0x1 == 1) {
                    a ^= (0x1 << i);
                    ++flippedBitCount;
                }
                if ((b >> i) & 0x1 == 1) {
                    b ^= (0x1 << i);
                    ++flippedBitCount;
                }   
            }
        }
    }

    return flippedBitCount;
}

int main () {
    int ans1 = minFlips(2,6,5);
    // 3
    printf("ANS: %d\n", ans1);

    int ans2 = minFlips(4,2,7);
    // 1
    printf("ANS: %d\n", ans2);

    int ans3 = minFlips(1,2,3);
    // 0
    printf("ANS: %d\n", ans3);
}
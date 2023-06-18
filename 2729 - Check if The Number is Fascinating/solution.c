#include <stdbool.h>
#include <stdlib.h>
#include <stdio.h>

bool isFascinating(int n){
    return n == 192 || n == 219 || n == 273 || n == 327;
}

bool isFascinatingCalculator(int n) {

    if (n > 333 || n % 5 == 0)
        return false;

    unsigned short bitField = 0b1111111000000000;
    unsigned short current = n;
    char i = 1;
    while (i < 4) {

        bitField |= 1 << (((current % 10u) - 1u) % 32);
        bitField |= 1 << ((((current / 10u) % 10u) - 1u) % 32);
        bitField |= 1 << (((current / 100u) - 1u) % 32);

        current = n * ++i;
    }

    return bitField == 0xFFFF;
}

int main() {
    for (int i = 100; i < 334; ++i)
        if (isFascinating(i))
            printf("%d\n", i);
}
#include <stdbool.h>
#include <stdlib.h>
#include <stdio.h>

bool isFascinating(int n){
    if (n > 333 || n % 5 == 0)
        return false;

    unsigned short bitField = 0b1111111000000000;
    short current = (short)n;
    char i = 1;
    char first, second, third;
    while (i < 4) {

        first = current % 10;
        second = (current / 10) % 10;
        third = current / 100;

        if (!first || !second || !third)
            return false;

        bitField |= 1 << --first;
        bitField |= 1 << --second;
        bitField |= 1 << --third;

        ++i;
        current = n * i;
    }

    return bitField == 0xFFFF;
}

int main() {
    printf("%d\n", isFascinating(192));
}
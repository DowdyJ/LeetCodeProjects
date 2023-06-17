#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <limits.h>

int getSeed(int x) {
    int newX = x;
    int numberOf100s = 0;

    while (newX > 100) {
        newX /= 100;
        numberOf100s++;
    }

    int coefficient = 1;

    while (numberOf100s > 0) {
        coefficient *= 10;
        numberOf100s--;
    }

    return (-190 / (newX + 20) + 10) * coefficient;
}

int mySqrt(int x){
    float lastChangeAmount = INT_MAX;
    double result = getSeed(x);

    while (lastChangeAmount > 0.05) {
        double newRes = 0.5 * (result + (x / (double)result));
        lastChangeAmount = abs(newRes - result);
        result = newRes;
    }
    
    return result;
}

int main() {
    printf("RESULT: %d\n", mySqrt(2147395599));
}
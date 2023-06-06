#include <stdlib.h>
#include <stdio.h>


int isSelfDividing(const int originalNumber) {
    int num = originalNumber;

    int currentDigit;

    while (num > 0) {
        currentDigit = num % 10;
        if (currentDigit == 0)
            return 0;

        num /= 10;
        if (originalNumber % currentDigit != 0)
            return 0;
    }

    return 1;

}


int* selfDividingNumbers(int left, int right, int* returnSize){

    int * nums = malloc(sizeof(int) * (right - left));
    *returnSize = 0;
    
    for (int i = left; i <= right; ++i) {
        if (isSelfDividing(i))
            nums[(*returnSize)++] = i;
    }

    return nums;
}


int main () {
    printf("RES: %d\n", isSelfDividing(21));
}
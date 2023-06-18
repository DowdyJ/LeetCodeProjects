#include <stdlib.h>


int* buildArray(int* nums, int numsSize, int* returnSize){
    *returnSize = numsSize;

    int* newNums = malloc(sizeof(int) * numsSize);

    for (short i = 0; i < numsSize; ++i) {
        newNums[i] = nums[nums[i]];
    }

    return newNums;
}
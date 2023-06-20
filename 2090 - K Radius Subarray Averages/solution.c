#include <stdlib.h>
#include <stdio.h>


int* getAverages(int* nums, int numsSize, int k, int* returnSize){
    *returnSize = numsSize;
    if (k == 0 || numsSize == 0)
        return nums;

    int* result = malloc(sizeof(int) * numsSize);
    *returnSize = numsSize;

    int i;
    for (i = 0; i < k && i < ((numsSize / 2) + 1); ++i) {
        result[i] = -1;
        result[numsSize - i - 1] = -1;
    }

    if (numsSize <= 2*k)
        return result;

    unsigned long long curSum = 0;

    for (i = 0; i <= 2*k; ++i) {
        curSum += nums[i];
    }

    result[k] = curSum / (2*k + 1);

    for (i = k + 1; i < numsSize - k; ++i) {
        curSum -= nums[i - (k + 1)];
        curSum += nums[i + k];
        result[i] = curSum / (2*k + 1);
    }

    return result;
}

int main() {
    int nums[] = {1,2,34,4,5,56,7,8,19,10,100};

    int returnSize = 0;
    int* result = getAverages(nums, 11, 3, &returnSize);
    for (int i = 0; i < returnSize; ++i) 
        printf("%d, ", result[i]);

    printf("\n");
}
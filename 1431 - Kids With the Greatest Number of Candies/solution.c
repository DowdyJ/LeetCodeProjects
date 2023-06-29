#include <stdbool.h>
#include <stdlib.h>
#include <stdio.h>


bool* kidsWithCandies(int* candies, int candiesSize, int extraCandies, int* returnSize){
    
    bool* restrict result = malloc(candiesSize * sizeof(bool));
    *returnSize = candiesSize;

    int maxValue = 0;

    for (int i = 0; i < candiesSize; ++i) {
        if (candies[i] > maxValue)
            maxValue = candies[i];
    }

    for (int i = 0; i < candiesSize; ++i) {
        result[i] = candies[i] + extraCandies >= maxValue;
    }

    return result;
}
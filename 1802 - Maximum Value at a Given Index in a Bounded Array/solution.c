#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>


int getBlocksFromSideTriangle(int sideTriangleHeight) {
    if (sideTriangleHeight <= 0)
        return 0;

    int res = 0;

    if (sideTriangleHeight % 2 == 1)
        res += sideTriangleHeight--;
    
    res += sideTriangleHeight / 2 * (sideTriangleHeight + 1);
    return res;
}

int blocksUsedByTrimmedTriangle(int n, int index, int maxSum, int triangleHeight) {   
    return (triangleHeight * triangleHeight) - (getBlocksFromSideTriangle(triangleHeight - index - 1) + getBlocksFromSideTriangle(triangleHeight - (n - index)));
}

int heightOfTriangle(int maxSum, int n, int index) {
    int height = 0;
    int layerCost = 1;
    while (layerCost <= maxSum) {
        height++;
        maxSum -= layerCost;

        if (index + (layerCost / 2 + 1) >= n || index - (layerCost / 2 + 1) < 0)
            layerCost += 1;
        else
            layerCost += 2;
    }

    return height;
}

int maxValue(int n, int index, int maxSum)  {
    int cachedMax = maxSum;
    maxSum -= n;

    if (maxSum == 0)
        return 1;

    int triangleHeight = heightOfTriangle(maxSum, n, index);

    return ((cachedMax - blocksUsedByTrimmedTriangle(n, index, maxSum, triangleHeight)) / n) + triangleHeight;
}



int main() {
    printf("ANS: %d\n", maxValue(8, 7, 14));

    return 0;
}
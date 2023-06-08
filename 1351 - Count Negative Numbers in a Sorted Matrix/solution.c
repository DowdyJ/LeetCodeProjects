#include <stdio.h>
#include <stdlib.h>




void getNegativeIndex(int* column, int left, int right, int* result) {
    if (*result != -1)
        return;

    if (column[left] < 0 || column[right] >= 0)
        return;

    if (right - left <= 1) {
        *result = right;
        return;
    }

    getNegativeIndex(
        column, 
        left, 
        (right - left) % 2 == 0 ? left + (right - left) / 2 : left + (right - left) / 2 + 1, 
        result);

    getNegativeIndex(
        column, 
        left + (right - left) / 2, 
        right, 
        result);
}

int countNegatives(int** grid, int gridSize, int* gridColSize){

    int result = 0;
    int localIndex;
    for (int i = 0; i < gridSize; ++i) {
        localIndex = -1;
        if (grid[i][0] < 0)
            localIndex = 0;
        else if (grid[i][*gridColSize - 1] > 0)
            continue;
        else
            getNegativeIndex(grid[i], 0, *gridColSize - 1, &localIndex);

        if (localIndex >= 0)
            result += *gridColSize - localIndex;
    }

    return result;

}

int main() {

    int** grid = calloc(2, sizeof(int*));

    for (int i = 0; i < 2; ++i) {
        grid[i] = calloc(4, sizeof(int));
    }

    grid[0][0] = 3;
    grid[0][1] = 2;
    grid[0][2] = 1;
    grid[0][3] = 1;

    grid[1][0] = -1;
    grid[1][1] = -1;
    grid[1][2] = -1;
    grid[1][3] = -1;

    int columnSize = 4;
    printf("ANS: %d\n", countNegatives(grid, 2, &columnSize));
}
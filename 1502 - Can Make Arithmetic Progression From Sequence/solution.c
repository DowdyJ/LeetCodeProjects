#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int partition(int const low, int const high, int* const arr, int const arrSize) {

    int slow = low -1;
    int pivot = arr[high];
    int temp;

    for (int fast = low; fast < high; ++fast) {
        if (arr[fast] < pivot) {
            if (arr[++slow] == arr[fast])
                continue;

            temp = arr[slow];
            arr[slow] = arr[fast];
            arr[fast] = temp;
        }
    }

    temp = arr[++slow];
    arr[slow] = arr[high];
    arr[high] = temp;

    return slow;
}

void quickSort(int* restrict const arr, int const arrSize, int const low, int const high) {
    if (low > high)
        return;

    int partitionIndex = partition(low, high, arr, arrSize);

    quickSort(arr, arrSize, low, partitionIndex - 1);
    quickSort(arr, arrSize, partitionIndex + 1, high);
}


bool canMakeArithmeticProgression(int* arr, int arrSize){
    quickSort(arr, arrSize, 0, arrSize -1);
    const int targetDifference = arr[1] - arr[0];

    for (int i = 0; i < arrSize - 1; ++i) {
        if (arr[i+1] - arr[i] != targetDifference)
            return false;
    }

    return true;
}

int main() {
    int* arr = malloc(sizeof(int) * 6);
    arr[0] = 2;
    arr[1] = 1;
    arr[2] = 3;
    arr[3] = 5;
    arr[4] = 6;
    arr[5] = 4;

    bool ans = canMakeArithmeticProgression(arr, 6);
    printf("Ans: %d", ans);
}

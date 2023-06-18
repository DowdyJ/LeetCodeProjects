#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

char ** fizzBuzz(int n, int* returnSize){

    const char* fizz = "Fizz"; // 3
    const char* buzz = "Buzz"; // 5
    const char* fizzbuzz = "FizzBuzz"; // 3 & 5

    char** result = malloc(sizeof(char*) * n);
    *returnSize = n;
    char* buffer;
    char buffSize = (char)log10(n) + 2;

    for (int i = 1;;) {
        if (i > n) break;

        buffer = calloc(buffSize, sizeof(char));
        sprintf(buffer, "%d\0", i);
        result[i++ - 1] = buffer;
        if (i > n) break;

        buffer = calloc(buffSize, sizeof(char));
        sprintf(buffer, "%d\0", i);
        result[i++ - 1] = buffer;
        if (i > n) break;

        result[i++ - 1] = fizz;
        if (i > n) break;

        buffer = calloc(buffSize, sizeof(char));
        sprintf(buffer, "%d\0", i);
        result[i++ - 1] = buffer;
        if (i > n) break;

        result[i++ - 1] = buzz;
        if (i > n) break;        

        result[i++ - 1] = fizz;
        if (i > n) break;

        buffer = calloc(buffSize, sizeof(char));
        sprintf(buffer, "%d\0", i);
        result[i++ - 1] = buffer;
        if (i > n) break;

        buffer = calloc(buffSize, sizeof(char));
        sprintf(buffer, "%d\0", i);
        result[i++ - 1] = buffer;
        if (i > n) break;

        result[i++ - 1] = fizz;
        if (i > n) break;

        result[i++ - 1] = buzz;
        if (i > n) break;  

        buffer = calloc(buffSize, sizeof(char));
        sprintf(buffer, "%d\0", i);
        result[i++ - 1] = buffer;
        if (i > n) break;

        result[i++ - 1] = fizz;
        if (i > n) break;        

        buffer = calloc(buffSize, sizeof(char));
        sprintf(buffer, "%d\0", i);
        result[i++ - 1] = buffer;
        if (i > n) break;

        buffer = calloc(buffSize, sizeof(char));
        sprintf(buffer, "%d\0", i);
        result[i++ - 1] = buffer;
        if (i > n) break;

        result[i++ - 1] = fizzbuzz;
        if (i > n) break;                            
    }

    return result;
}

int main() {



}
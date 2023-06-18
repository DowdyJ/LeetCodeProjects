#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

// minimal modulo and division
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

// more standard approach
char ** fizzBuzz2(int n, int* returnSize){

    *returnSize = n;
    char** result = malloc(sizeof(char*) * n);
    
    char* buffer;
    char buffSize = (char)log10(n) + 2;

    for (int i = 1; i <= n; ++i) {
       
        if (i % 5 == 0) {
            if (i % 3 == 0) {
                result[i - 1] = "FizzBuzz";
                continue;
            }

            result[i - 1] = "Buzz";
        }
        else if (i % 3 == 0) {
            result[i - 1] = "Fizz";
        }
        else {
            buffer = calloc(buffSize, sizeof(char));
            sprintf(buffer, "%d\0", i);
            result[i - 1] = buffer;
        }
    }

    return result;
}

int main() {



}
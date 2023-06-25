#include <stdlib.h>
#include <string.h>
#include <stdio.h>

char * mergeAlternately(char * word1, char * word2){
    int index1 = 0;
    int index2 = 0;

    char* result = malloc((strlen(word1) + strlen(word2) + 1) * sizeof(char));

    while (word1[index1] != 0 && word2[index2] != 0)
    {
        result[index1 + index2] = word1[index1++];
        result[index1 + index2] = word2[index2++];
    }

    if (word1[index1] == 0 ^ word2[index2] == 0) {
        if (word1[index1] == 0) {
            while (word2[index2] != 0) {
                result[index1 + index2] = word2[index2++];
            }
        }
        else {
            while (word1[index1] != 0) {
                result[index1 + index2] = word1[index1++];
            }        
        }
    }

    result[index1 + index2] = 0;

    return result;
}

// The extra increment of result is required on leetcode but doesn't work locally and vice versa
char * mergeAlternatelyLeetCodeVersion(char * word1, char * word2){
    int index1 = 0;
    int index2 = 0;

    char* result = malloc((strlen(word1) + strlen(word2) + 2) * sizeof(char));

    while (word1[index1] != 0 && word2[index2] != 0)
    {
        result[index1 + index2] = word1[index1++];
        result[index1 + index2] = word2[index2++];
    }

    if (word1[index1] == 0 ^ word2[index2] == 0) {
        if (word1[index1] == 0) {
            while (word2[index2] != 0) {
                result[index1 + index2] = word2[index2++];
            }
        }
        else {
            while (word1[index1] != 0) {
                result[index1 + index2] = word1[index1++];
            }        
        }
    }

    result[index1 + index2 + 1] = 0;

    return result + 1;
}


int main() {
    char test[] = "abc";
    char test2[] = "pqr";
    //apbqcr
    printf("%s\n", mergeAlternately(test, test2));
}
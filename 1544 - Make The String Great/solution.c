#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>

char * makeGood(char * s){
    if (!s || s[0] == 0)
        return s;

    bool changed = false;
    int len = strlen(s);
    char* s_copy = calloc(len + 1, sizeof(char));
    strcpy(s_copy, s);
    int i, insertionIndex;
    char* retVal;

    do {
        changed = false;
        retVal = calloc(len + 1, sizeof(char));
        insertionIndex = 0;
        i = 1;

        for(; i < len; ++i) {
            if (abs(s_copy[i - 1] - s_copy[i]) != 32) {
                retVal[insertionIndex++] = s_copy[i-1];
            }
            else {
                changed = true;
                s_copy[i] = '-';
                ++i;
            }
        }
        
        if (changed) {
            retVal[insertionIndex] = s_copy[i - 1];
            s_copy = realloc(s_copy, strlen(retVal) + 2);
            strcpy(s_copy, retVal);
        }
        
        free(retVal);
        len = strlen(s_copy);
        
    } while (changed);

    return s_copy;
}

int main() {
    //char test[] = "s";
    //printf("%s\n", makeGood(test));

    //char test1[] = "leEeetcode";
    //printf("%s\n", makeGood(test1));

    char test2[] = "abBAcC";
    printf("%s\n", makeGood(test2));

    //char test3[] = "leEeetcode";
    //printf("%s\n", makeGood(test3));
    return 0;
}
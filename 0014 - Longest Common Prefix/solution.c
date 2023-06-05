#include <stdlib.h>
#include <stdio.h>

char * longestCommonPrefix(char ** strs, int strsSize){
    char* matchingPrefix = calloc(200, sizeof(char));
    unsigned char matchingIndexLength = 200;
    for (unsigned char stringIndex = 0; stringIndex < strsSize; ++stringIndex) {
        for (unsigned char charIndex = 0; charIndex < matchingIndexLength; ++charIndex) {
            if (matchingPrefix[charIndex] == 0) {
                matchingPrefix[charIndex] = strs[stringIndex][charIndex];
            }
            
            if (strs[stringIndex][charIndex] == 0 || strs[stringIndex][charIndex] != matchingPrefix[charIndex]) {
                matchingIndexLength = matchingIndexLength > charIndex ? charIndex : matchingIndexLength;
                break;
            }
        }
    }

    matchingPrefix[matchingIndexLength] = 0;
    
    return matchingPrefix;
}


int main() {
    char** args = malloc(sizeof(char*) * 3);
    for (int i =0; i<3u; ++i) {
        args[i] = calloc(5, sizeof(char));
    }

    args[0] = "floop";
    args[1] = "floor";
    args[2] = "flub";

    char* res = longestCommonPrefix(args, 3);
    printf("%s", res);
}
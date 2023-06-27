#include <stdbool.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

bool isIsomorphic(char * s, char * t){
    int sLength = strlen(s);
    int tLength = strlen(t);

    if (sLength != tLength)
        return false;

    unsigned char* map1 = malloc(sizeof(unsigned char) * 128);
    unsigned char* map2 = malloc(sizeof(unsigned char) * 128);

    for (int i = 0; i < sLength; ++i) {
        map1[s[i]] = t[i];
        map2[t[i]] = s[i];
    }

    for (int i = 0; i < sLength; ++i) {
        if (map1[s[i]] != t[i] || map2[t[i]] != s[i]) {
            free(map1);
            free(map2);
            return false;
        }
    }

    free(map1);
    free(map2);
    return true;
}

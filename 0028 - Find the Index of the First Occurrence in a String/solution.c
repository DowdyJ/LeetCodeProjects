#include <stdio.h>
int strStr(char * haystack, char * needle){
    int matchStartIndex = -1;

    for (int i = 0; haystack[i] != 0; ++i) {
        if (haystack[i] != needle[0])
            continue;

        matchStartIndex = i;
        for (int j = 1; ;) {
            if (needle[j] == 0)
                return matchStartIndex;

            if (haystack[++i] != needle[j]) {
                break;
            } 
            else if (needle[++j] == 0) {
                return matchStartIndex;
            }
        }

        i = matchStartIndex++;

        if (haystack[i] == 0)
            break;
    }

    return -1;
}

int main() {
    char* dogger = "mississippi";
    char* dog = "issip";
    printf("Match start index: %d", strStr(dogger, dog));
}

#include <stdio.h>


int lengthOfLastWord(char * s){

    int indexOfFinalFirstChar = -1;
    unsigned char lastCharWasSpace = 1;

    for (int i = 0; s[i] != 0; ++i) {
        if (lastCharWasSpace && s[i] != ' ')
            indexOfFinalFirstChar = i;

        lastCharWasSpace = s[i] == ' ';
    }

    int i;
    for (i = indexOfFinalFirstChar; s[i] != 0; ++i) {
        if (s[i] == ' ')
            break;
    }

    return i - indexOfFinalFirstChar;
}

int main() {
    char* arg = "   fly me   to   the moon";
    printf("ANS: %d\n", lengthOfLastWord(arg));
}
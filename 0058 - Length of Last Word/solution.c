#include <stdio.h>


int lengthOfLastWord(char * s){

    short indexOfFinalFirstChar = -1;
    unsigned char lastCharWasSpace = 1;

    for (short i = 0; s[i] != 0; ++i) {
        if (lastCharWasSpace && s[i] != ' ')
            indexOfFinalFirstChar = i;

        lastCharWasSpace = s[i] == ' ';
    }

    short i;
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
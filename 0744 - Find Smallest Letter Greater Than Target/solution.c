#include <stdlib.h>
#include <stdio.h>

char nextGreatestLetter(char* letters, int lettersSize, char target){

    for (short i = 0; i < lettersSize; ++i) {
        if (letters[i] <= target)
            continue;

        return letters[i];
    }

    return letters[0];
}

short getIndex(char* letters, int lettersSize, char target, short curIndex, short high) {
    if (letters[curIndex] == target && curIndex + 1 < lettersSize && letters[curIndex + 1] != target) {
        return curIndex + 1;
    }

    if (letters[high] <= target || letters[curIndex] > target)
        return -1;

    short res;
    res = getIndex(letters, lettersSize, target, curIndex + (high - curIndex) / 2, high);

    if (res != -1)
        return res;

    res = getIndex(letters, lettersSize, target, curIndex, (high - curIndex) / 2);
    if (res != -1)
        return res;

    return -1;
}



int main () {
    printf("ANS: %d\n", getIndex("abcdefg", 7, 'd', 0, 6));
    printf("ANS: %c\n", nextGreatestLetter("abcdefg", 7, 'd'));

    return 0;
}
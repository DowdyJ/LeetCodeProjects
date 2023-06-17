#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

void swap(char* string, int i, int j) {
    char temp = string[i];
    string[i] = string[j];
    string[j] = temp;
}


void partition(char* string, int low, int high, int* left, int* right) {
    *right = high;
    int mid = low;
    char pivot = string[high];

    while (mid <= *right) {
        if (string[mid] < pivot) {
            swap(string, low++, mid++);
        } 
        else if (string[mid] > pivot) {
            swap(string, mid, (*right)--);
        } 
        else {
            mid++;
        }
    }

    *left = low-1;
    *right = mid;
}

void quicksort(char* string, int low, int high) {

    if (high < low)
        return;

    int left, right;

    partition(string, low, high, &left, &right);

    quicksort(string, low, left);
    quicksort(string, right, high);
}

bool isAnagram(char * s, char * t){

    unsigned short i = 0;

    for (; ; ++i) {
        if (s[i] == 0 ^ t[i] == 0)
            return false;
        else if (s[i] == 0)
            break;
    }
    
    quicksort(s, 0, i - 1);
    quicksort(t, 0, i - 1);

    i = 0;

    for (;;++i) {
        if (s[i] == 0)
            break;

        if (s[i] != t[i])
            return false;
    }

    return true;
}


bool isAnagram2(char * s, char * t){

    short* charCount = calloc(26, sizeof(short));

    unsigned short i = 0;

    for (; s[i] != 0 && t[i] != 0; ++i) {
        charCount[s[i] - 97]++;
        charCount[t[i] - 97]--;
    }

    if (s[i] != t[i])
        return false;

    i = 0;
    for (; i < 26; ++i)
        if (charCount[i] != 0)
            return false;

    return true;
}




int main() {
    
    char test1[] = "weewoo";
    char test2[] = "eewoow";

    // printf("%s\n", test1);
    // printf("%s\n", test2);

    // quicksort(test1, 0, 5);
    // quicksort(test2, 0, 5);

    // printf("%s\n", test1);
    // printf("%s\n", test2);

    printf("%d\n", isAnagram(test1, test2));
    
}
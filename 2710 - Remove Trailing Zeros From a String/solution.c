#include <stdio.h>
#include <string.h>

char * removeTrailingZeros(char * num){
    short i = strlen(num) - 1;

    while ( i >= 0 ) {
        if (num[i--] != '0')
            break;
    }

    num[i + 2] = 0;

    return num;
}
int main() {
    char test[] = "82164031450000";
    printf("%s\n", removeTrailingZeros(test));

    return 0;
}
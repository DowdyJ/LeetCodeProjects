#include <string.h>
#include <stdlib.h>
#include <stdio.h>

char * defangIPaddr(char * address){
    char* result = calloc(strlen(address) + 1 + 6, sizeof(char));

    char i = 0;
    char offset = 0;
    while (address[i] != 0) {
        if (address[i] != 46) {
            result[i + offset] = address[i]; 
        }
        else {
            result[i + offset] = '[';
            result[i + ++offset] = '.';
            result[i + ++offset] = ']';
        }
        ++i;
    }

    return result;
}

int main() {
    char test[] = "123.123.123.123";
    printf("%s\n", defangIPaddr(test));
    return 0;
}
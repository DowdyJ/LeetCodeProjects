#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char * multiply(char * num1, char * num2){
    if (num1[0] == '0')
        return num1;

    if (num2[0] == '0')
        return num2;

    if (num1[0] == '1' && num1[1] == 0)
        return num2;

    if (num2[0] == '1' && num2[1] == 0)
        return num1;

    int number1 = 0;
    int number2 = 0;

    int placeValue = 1;

    for (int i = strlen(num1) - 1; i >= 0; i--) {
        number1 += (num1[i] - 48) * placeValue;
        placeValue *= 10;
    }

    int placeValue2 = 1;

    for (int i = strlen(num2) - 1; i >= 0; i--) {
        number2 += (num2[i] - 48) * placeValue2;
        placeValue2 *= 10;
    }

    unsigned long long int numRes = number1 * number2;
    unsigned long long int numRes2 = numRes;
    placeValue = 0;
    while (numRes2 > 0) {
        numRes2 /= 10;
        placeValue++;
    }

    char* res = malloc(placeValue + 1);
    res[placeValue] = 0;

    number2 = 1;
    while (numRes > 0) {
        res[placeValue - number2] = (char)(48 + (numRes % 10));
        numRes /= 10;
        ++number2;
    }

    return res;
}


int main() {
    printf("ANS: %s\n", multiply("123456789", "987654321"));
}
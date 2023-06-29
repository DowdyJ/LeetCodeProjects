#include <stdlib.h>
#include <string.h>
#include <stdio.h>

char * gcdOfStrings(char * str1, char * str2){

    if (str1[0] != str2[0])
        return "";

    int n1 = strlen(str1);
    int n2 = strlen(str2);

    while(n1 != n2)
    {
        if(n1 > n2)
            n1 -= n2;
        else
            n2 -= n1;
    }

    int gcd = n1;
    int i;

    n1 = strlen(str1);
    for (i = 0; i < n1; ++i) {
        if (str1[i] != str1[i % gcd])
            return "";
    }

    if (i % gcd != 0)
        return "";

    n2 = strlen(str2);
    for (i = 0; i < n2; ++i) {
        if (str2[i] != str2[i % gcd])
            return "";
    }

    if (i % gcd != 0)
        return "";
        
    str1[gcd] = 0;
    return str1;
}
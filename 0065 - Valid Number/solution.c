#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>


extern inline bool isNumberASCII(char c) {
    return !(c < (char)48 || c > (char)57);
}

void trimSpaces(char* restrict token) {
    int slow = 0;
    int fast = 0;

    while (token[fast] == ' ')
        ++fast;
    
    if (fast == slow)
        return;


    for (; token[fast] != 0; ++fast, ++slow)
        token[slow] = token[fast];

    token[slow] = 0;    
}

// assumes no spaces
bool tokenIsInteger(char* restrict token) {
    
    unsigned char i = 0;
    if (token[i] == '+' || token[i] == '-') {
        if (token[i+1] == 0)
            return false;
        
        ++i;
    }

    for (; token[i] != 0; ++i) {
        if ( !isNumberASCII(token[i]) ) {
            return false;
        }
    }

    return true;
}


// assumes no spaces
bool tokenIsDecimal(char* restrict token) {

    for (int i = 0; token[i] != 0; ++i) {
        if (token[i] == '.') {
            if ((i == 0 || !isNumberASCII(token[i -1])) && (!isNumberASCII(token[i + 1])))
                return false;

            token[i] = '1';
            break;
        }
    }

    return tokenIsInteger(token);    
}

//chews up input ᕦ༼✩ل͜✩༽ᕤ
bool isNumber(char * s){
    
    trimSpaces(s);

    for (int i = 0; s[i] != 0; ++i) {
        if (s[i] == 'e' || s[i] == 'E') {
            if ( i == 0 || 
                (!isNumberASCII(s[i -1]) && s[i-1] != '.') || 
                (!isNumberASCII(s[i+1]) && (s[i+1] != '-' || !isNumberASCII(s[i+2])) && (s[i+1] != '+' || !isNumberASCII(s[i+2])))) 
            {
                return false;
            }

            bool afterEIsInteger = tokenIsInteger(&s[i+1]);
            s[i] = 0;
            bool beforeEIsDecimal = tokenIsDecimal(s);

            return afterEIsInteger && beforeEIsDecimal;
        }
    }

    return tokenIsDecimal(s);
}


int main () {


    char test2[] = "4e+";
    bool ans2 = isNumber(test2);
    printf("%d\n", ans2);

    return 0;
}
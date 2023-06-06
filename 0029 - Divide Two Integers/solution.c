#include <stdio.h>


int divide(int dividend, int divisor){
    unsigned int result = 0;
    unsigned char isNegative = 0;

    if (divisor == 1)
        return dividend;
    
    if (divisor == -1) {
        if (dividend == -2147483648) {
            return 2147483647;
        }

        dividend = ~dividend;
        return ++dividend;
    }

    if (divisor == -2147483648) {
        if (dividend != -2147483648)
            return 0;
        else
            return 1;
    }

    if (dividend == -2147483648) {

        if (divisor > 0)
            dividend += divisor;
        else
            dividend -= divisor;

        result++;
    }



    if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
        isNegative = 1;

        if (dividend < 0) {
            dividend = ~dividend;
            dividend++;
        }

        if (divisor < 0) {
            divisor = ~divisor;
            divisor++;
        }
    } 
    else if (dividend < 0 && divisor < 0) {
        dividend = ~dividend;
        dividend++;
        
        divisor = ~divisor;
        divisor++;
    }

    while (dividend >= divisor) {
        result ++;
        dividend -= divisor;
    }


    if (isNegative) {
        result = ~result;
        result++;
    }

    return result;
}

int main () {
    printf("ANS: %d\n", divide(5,2));
    printf("ANS: %d\n", divide(4,2));
    printf("ANS: %d\n", divide(5,1));
    printf("ANS: %d\n", divide(5,-2));
    printf("ANS: %d\n", divide(-5,-2));

}
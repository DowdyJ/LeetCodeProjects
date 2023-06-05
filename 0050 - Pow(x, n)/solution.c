#include <stdio.h>
#include <stdbool.h>

double myPow(double x, int n)
{
    if (n == 0 || x == 1)
        return 1;

    if (x == -1)
        return n % 2 == 0 ? x : -x;

    if (x == 0)
        return 0;

    double res = 1;
    if (n > 0) {
        for (int i = 0; i < n; ++i) {
            res *= x;
        } 
    }
    else {
        for (int i = 0; i > n; --i) {
            res *= 1/x;
            if (res == 0)
                break;
        }
    } 

    return res;
}


double myPowFast(double x, int n)
{
    if (n == 0 || x == 1)
        return 1;

    if (x > 1 && n < -2000000000)
        return 0;

    if (x == -1)
        return n % 2 == 0 ? x : -x;

    if (x == 0)
        return 0;

    bool isNegativeExponent = n < 0;
    if (isNegativeExponent)
        n *= -1;

    double base = x;
    double extra = 1;

    if (n > 0) {
        while (n > 1) {
            if (n % 2 == 1) {
                extra *= base;
                n--;
                continue;
            }

            base *= base;
            n /= 2;
        } 
    }

    while (n > 1) {
        if (n % 2 == 1) {
            extra *= base;
            n--;
            continue;
        }

        base *= base;
        n /= 2;
    }

    return isNegativeExponent ? 1 / (base * extra) : base * extra;
}

int main()
{
    //printf("%f\n", myPowFast(3, 2));
    //printf("%f\n", myPowFast(3, 1));
    //printf("%f\n", myPowFast(3, 0));
    printf("%f\n", myPowFast(2, 10));
    //printf("%f\n", myPowFast(5, 4));

    return 0;
}
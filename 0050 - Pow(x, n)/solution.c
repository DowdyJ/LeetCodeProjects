#include <stdio.h>

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

int main()
{
    printf("%f\n", myPow(2, 2));
    printf("%f\n", myPow(2, 1));
    printf("%f\n", myPow(2, 0));
    printf("%f\n", myPow(10, 2));
    printf("%f\n", myPow(5, 2));

    return 0;
}
using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.IO;
using System.Linq;

namespace LC202;

public class Solution {
    public static int Main(string[] args) {
        var s = new Solution();
        Console.WriteLine($"Happy: {s.IsHappy(19)}");
        return 0;
    }

    public bool IsHappy(int n) {
        HashSet<int> usedNumbers = new();
        
        int sumVal = 0;
        while (sumVal != 1) {

            sumVal = SumOfDigitsSquared(n);
            if (usedNumbers.Contains(sumVal)) {
                return false;
            } else {
                usedNumbers.Add(sumVal);
            }
            n = sumVal;
        }
        
        return true;
    }

    private static int SumOfSquareIntList(List<int> list) {
        int sum = 0;
        foreach (int i in list)
            sum += (i * i);

        return sum;
    }

    private static List<int> IntToIntList(int n) {
        List<int> numberAsDigits = new();

        while (n > 0) {
            numberAsDigits.Add(n % 10);
            n = n / 10;
        }

        return numberAsDigits;
    }

    private static int SumOfDigitsSquared(int n) {
        int sumOfSquaredDigits = 0;

        while (n > 0) {
            sumOfSquaredDigits += (n % 10) * (n % 10);
            n = n / 10;
        }

        return sumOfSquaredDigits;
    }
}
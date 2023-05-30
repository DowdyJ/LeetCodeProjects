package dev.sugaroflead.lc7;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }


    public int reverse(int x) {
        try {
            int sign = x > 0 ? 1 : -1;
            int result = 0;

            x = Math.multiplyExact(x, sign);

            int divisor = 1000000000;
            int[] numberAsDigits = new int[10];
            while (x >= 1) {
                int res = x / divisor;
                numberAsDigits[9 - (int)Math.log10(divisor)] = res;
                x -= res * divisor;
                divisor /= 10;
            }

            int placeValue = 1;
            boolean nonLeadingZeroFound = false;
            for (int i = 0; i < numberAsDigits.length; ++i) {
                if (!nonLeadingZeroFound && numberAsDigits[i] == 0)
                    continue;

                nonLeadingZeroFound = true;
                result = Math.addExact(result, Math.multiplyExact(numberAsDigits[i], placeValue));
                placeValue *= 10;
            }

            return result * sign;
        }
        catch (ArithmeticException e) {
            return 0;
        }
    }
}

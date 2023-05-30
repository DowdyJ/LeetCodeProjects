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
            x = Math.multiplyExact(x, sign);

            int placeValue = 1000000000;
            int[] numberAsDigits = new int[10];
            while (x >= 1) {
                int res = x / placeValue;
                numberAsDigits[9 - (int)Math.log10(placeValue)] = res;
                x -= res * placeValue;
                placeValue /= 10;
            }

            placeValue = 1;
            x = 0;
            
            boolean nonLeadingZeroFound = false;
            for (int i = 0; i < numberAsDigits.length; ++i) {
                if (!nonLeadingZeroFound && numberAsDigits[i] == 0)
                    continue;

                nonLeadingZeroFound = true;
                x = Math.addExact(x, Math.multiplyExact(numberAsDigits[i], placeValue));
                placeValue *= 10;
            }

            return x * sign;
        }
        catch (ArithmeticException e) {
            return 0;
        }
    }
}

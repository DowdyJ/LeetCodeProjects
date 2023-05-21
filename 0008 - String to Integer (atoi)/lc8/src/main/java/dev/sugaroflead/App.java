package dev.sugaroflead;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        long start = System.nanoTime();
        App a = new App();
        a.myAtoi(" ++47");
        long end = System.nanoTime();
        System.out.println("TIME:" + (end - start));
    }

    public int myAtoi(String s) {
        s = s.trim();
        int sign = 1;
        int convertedValue = 0;

        if (s.length() == 0)
            return 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        } else if (s.charAt(0) < 48 || s.charAt(0) > 57) {
            return 0;
        }

        try {
            int stringLength = s.length();
            for (int i = 0; i < stringLength; i++) {
                char currentChar = s.charAt(i);
                if (currentChar < 48 || currentChar > 57)
                    break;

                convertedValue = Math.multiplyExact(convertedValue, 10);
                convertedValue = Math.addExact(convertedValue, currentChar - 48);
            }
        } catch (ArithmeticException e) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return sign * convertedValue;
    }
}

package dev.sugaroflead;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int myAtoi(String s) {
        s = s.trim();
        int placeValue = 1;
        int sign = 1;
        int convertedValue = 0;

        if (s.length() == 0)
            return 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            s = s.replaceFirst("-", "");
        } else if (s.charAt(0) == '+') {
            s = s.replaceFirst("\\+", "");
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
                convertedValue = Math.addExact(convertedValue, CharToInt(currentChar));
            }
        } catch (ArithmeticException e) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return sign * convertedValue;
    }

    private static final int CharToInt(char c) {
        return c - 48;
    }

}

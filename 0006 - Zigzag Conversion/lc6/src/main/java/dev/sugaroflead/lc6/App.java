package dev.sugaroflead.lc6;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        App a = new App();
        String res = a.convert("PAYPALISHIRING", 3);
        //assertEquals("PAHNAPLSIIGYIR", res);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() < numRows)
            return s;

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; ++i) {
            rows[i] = new StringBuilder();
        }

        int directingIndex = -1;
        boolean descending = true;
        for (int charIndex = 0; charIndex < s.length(); ++charIndex) {
            if (descending) {
                rows[++directingIndex].append(s.charAt(charIndex));
            } else {
                rows[--directingIndex].append(s.charAt(charIndex));
            }

            if (directingIndex == 0) {
                descending = true;
            } else if (directingIndex == numRows - 1) {
                descending = false;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }

        return result.toString();
    }
}

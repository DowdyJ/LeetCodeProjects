package dev.sugaroflead;


class Solution {
    public int countHomogenous(String s) {
        
        char currentChar;
        int startIndex = 0;
        int endIndex = 0;

        long substringCount = 0;
        long moduloValue = 1000000007;

        currentChar = s.charAt(0);

        for (int i = 0; i < s.length(); ++i) {
            startIndex = i;

            while (endIndex < s.length() && s.charAt(endIndex) == currentChar) {
                endIndex++;
            }

            substringCount += (getPermutationsCount(endIndex - startIndex) % moduloValue);
            substringCount %= moduloValue;
            if (endIndex < s.length())
                currentChar = s.charAt(endIndex);
                
            i = endIndex - 1;
        }

        return ((int)substringCount);
    }

    public long getPermutationsCount(long stringLength) {
        return ((stringLength + 1) * stringLength) / 2;
    }
}
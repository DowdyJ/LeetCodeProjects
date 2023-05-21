package dev.sugaroflead;

import java.util.HashMap;
import java.util.Map;

public class App 
{
    public static void main( String[] args )
    {
        long start = System.nanoTime();
        App a = new App();
        a.lengthOfLongestSubstring("abc");
        long end = System.nanoTime();
        System.out.println("TIME:" + (end - start));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seenLetters = new HashMap<Character,Integer>();
        int maxLength = 0;
        int currentLength = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (seenLetters.containsKey(s.charAt(i))) {

                i = seenLetters.get(s.charAt(i)) + 1;
                seenLetters.clear();

                if (currentLength > maxLength)
                    maxLength = currentLength;

                currentLength = 0;
                
            }
            seenLetters.put(s.charAt(i), i);
            currentLength++;
        }

        if (currentLength > maxLength)
            maxLength = currentLength;

        return maxLength;
    }
}

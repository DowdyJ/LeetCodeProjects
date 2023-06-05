package dev.sugaroflead.lc10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

import javax.naming.PartialResultException;

public class App 
{
    public static void main( String[] args )
    {
        App a = new App();
        Queue<String> q = a.tokenizePattern("a*");
        
        boolean res = a.isMatch("ab", ".*c");
        
        for (String s : q)
            System.out.println(s);
    }

    public boolean isMatch(String s, String p) {
        if (s.equals(p))
            return true;

        Deque<String> tokenizedPattern = tokenizePattern(p);

        for (int stringIndex = 0; stringIndex < s.length();) {
            
            if (tokenizedPattern.size() == 0)
                return false;

            String currentPattern = tokenizedPattern.poll();

            if (currentPattern.equals(".*")) {
                return runBackward(s, stringIndex, tokenizedPattern);
            }
            else if (currentPattern.equals(".")) {
                stringIndex++;
                continue;
            }

            if (currentPattern.length() == 1) {
                if (s.charAt(stringIndex) != currentPattern.charAt(0)) 
                    return false;
                else {
                    stringIndex++;
                    continue;
                }
            }


            if (currentPattern.length() > 1) {
                while (stringIndex < s.length() && s.charAt(stringIndex) == currentPattern.charAt(0))
                    stringIndex++;
            }

        }

        return tokenizedPattern.size() == 0;
    }

    private boolean runBackward(String input, int stringIndexForward, Deque<String> tokenDeque) {

        for (int stringIndexBack = input.length() - 1; stringIndexBack > stringIndexForward;) {
            String currentToken = tokenDeque.pop();

            if (currentToken.equals(".*")) {
                return runBackward(input, stringIndexBack, tokenDeque);
            }
    
            if (currentToken.length() == 1) {
                if (currentToken.charAt(0) == input.charAt(stringIndexBack)) {
                    stringIndexBack--;
                    continue;
                } else {
                    return false;
                }
            }
            else {
                while (stringIndexBack > stringIndexForward && input.charAt(stringIndexBack) == currentToken.charAt(0))
                    stringIndexBack--;
            }
        }

        return tokenDeque.size() == 0;
    }

    private Deque<String> tokenizePattern(String pattern) {
        Deque<String> result = new ArrayDeque<String>();

        StringBuilder currentToken = new StringBuilder();

        for (int i = 0; i < pattern.length(); ++i) {
            currentToken.append(pattern.charAt(i));

            if (i + 1 < pattern.length() && pattern.charAt(i + 1) != '*') {
                result.add(currentToken.toString());
                currentToken = new StringBuilder(); 
            }
        }

        result.add(currentToken.toString());

        return result;
    }
}

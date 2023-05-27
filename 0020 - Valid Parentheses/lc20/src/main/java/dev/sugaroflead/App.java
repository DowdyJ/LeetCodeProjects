package dev.sugaroflead;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static Map<Character, Character> parenthesisPairs;
    static {
        parenthesisPairs = new HashMap<>();
        parenthesisPairs.put('(', ')');
        parenthesisPairs.put('[', ']');
        parenthesisPairs.put('{', '}');
    }

    public boolean isValid(String s) {
        Stack<Character> expectedClosingChar = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (parenthesisPairs.containsKey(c)) {
                expectedClosingChar.add(parenthesisPairs.get(c));
            } 
            else {
                if (expectedClosingChar.isEmpty() || expectedClosingChar.pop() != c)
                    return false;
            }
        }

        return expectedClosingChar.isEmpty();
    }
}

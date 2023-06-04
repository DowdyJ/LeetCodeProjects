package dev.sugaroflead.lc38;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        App a = new App();
        String res = a.countAndSay(3);
    }

    public String countAndSay(int n) {
        String lastResult = "";
        for (int i = 0; i < n; ++i) {
            lastResult = say(lastResult);
        }

        return lastResult;
    }

    private String say(String input) {
        if (input.equals(""))
            return "1";

        StringBuilder sb = new StringBuilder();
        char lastCharacter = input.charAt(0);
        char count = 1;

        for (int i = 1; i < input.length(); ++i) {
            char currentChar = input.charAt(i);
            
            if (currentChar == lastCharacter) {
                count++;
            } 
            else 
            {
                sb.append((char)(48 + count));
                sb.append(lastCharacter);
                count = 1;
                lastCharacter = currentChar;
            }
        }

        sb.append((char)(48 + count));
        sb.append(lastCharacter);

        return sb.toString();
    }
}

public class Solution {
    public int RomanToInt(string s) {
        List<string> tokenizedInput = TokenizeInput(s);
        return ConvertTokensToIntSum(tokenizedInput);
    }

    private int ConvertTokensToIntSum(List<string> tokens) 
    {
        int total = 0;
        
        foreach (var t in tokens) 
        {
            if (t.Length == 0)
            {
                continue;
            }
            else if (t.Length == 1)
            {
                total += romanValuePairs[t[0]];
                continue;
            }

            bool subtractFirst = romanValuePairs[t[0]] < romanValuePairs[t[1]];

            int subtotal = 0;
            foreach (char c in t) 
            {
                if (subtractFirst) 
                {
                    subtotal -= romanValuePairs[c];
                    subtractFirst = false;
                    continue;
                }

                subtotal += romanValuePairs[c];
            }

            total += subtotal;
        }

        return total;
    }

    private List<string> TokenizeInput(string input) 
    {
        List<string> tokens = new List<string>();

        string currentToken = "";
        for (int i = 0; i < input.Length; i++) 
        {
            char currentChar = input[i];
            char previousChar = currentToken.Length == 0 ? ' ' : currentToken[currentToken.Length - 1];
            
            if (previousChar == ' ') 
            {
                currentToken += currentChar;
                continue;
            }

            if (romanValuePairs[previousChar] <= romanValuePairs[currentChar]) 
            {
                currentToken += currentChar;
            }
            else 
            {
                tokens.Add(currentToken);
                currentToken = $"{currentChar}";
            }
        }

        tokens.Add(currentToken);

        return tokens;
    }

    Dictionary<char, int> romanValuePairs = new Dictionary<char, int>() 
    {
        {'I', 1},
        {'V', 5},
        {'X', 10},
        {'L', 50},
        {'C', 100},
        {'D', 500},
        {'M', 1000}
    };
}
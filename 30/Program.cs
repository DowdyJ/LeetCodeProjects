
using System.Text.RegularExpressions;

namespace LC30;

class Program 
{
    public static int Main(string[] args) 
    {
        string input = "abaaaab";
        Regex regex = new Regex(@"(?=(aaa))(\1)", RegexOptions.None);

        foreach(var match in regex.Matches(input).AsEnumerable()) 
        {
            Console.WriteLine(match.Value);
        }

        return 0;
    }

    public IList<int> FindSubstring(string s, string[] words) 
    {
        List<string> tokens = TokenizeInputString(s, words);

        List<ComboToken> comboTokens = MakeComboTokens(tokens, words);

        comboTokens = MakeSubTokens(comboTokens, words);

        FilterOutTokensWhichDoNotContainFullPermutations(comboTokens, words);

        List<int> answers = new();
        foreach (var ct in comboTokens)
            answers.Add(ct.index);

        return answers;
    }

    private struct ComboToken 
    {
        public ComboToken(int index, string text) 
        {
            this.index = index;
            this.text = text;
        }

        public string text;
        public int index;
    }

    private static List<ComboToken> MakeSubTokens(List<ComboToken> comboTokens, string[] words) 
    {
        List<ComboToken> subTokens = new();

        int totalRequiredLength = 0;

        foreach (var word in words) 
            totalRequiredLength += word.Length;

        for (int i = 0; i < comboTokens.Count; ++i) {
            if (comboTokens[i].text.Length == totalRequiredLength) {
                subTokens.Add(comboTokens[i]);
                comboTokens.Remove(comboTokens[i]);
                --i;
            } 
            else if (comboTokens[i].text.Length < totalRequiredLength) {
                comboTokens.Remove(comboTokens[i]);
                --i;
            }
        }

        int wordSize = words[0].Length;
        int currentWordIndex = 0;
        while (comboTokens.Count > 0) 
        {
            var currentToken = comboTokens[0];

            for (int i = 0; i <= (currentToken.text.Length / wordSize) - words.Length; ++i) 
            {
                subTokens.Add(
                    new ComboToken(currentToken.index + i * wordSize, currentToken.text.Substring(i * wordSize, words.Length * wordSize)));
            }
            
            comboTokens.Remove(currentToken);
        }

        return subTokens;
    }

    private void FilterOutTokensWhichDoNotContainFullPermutations(List<ComboToken> comboTokens, string[] words) 
    {
        List<ComboToken> goodTokens = new();

        
        Dictionary<string, bool> keywordOccuranceRecordTemplate = new();

        foreach (var w in words) 
            keywordOccuranceRecordTemplate.Add(w, false);

        int curIndex = 0;

        foreach (var ct in comboTokens) {
            Dictionary<string, bool> keywordOccuranceRecord = new(keywordOccuranceRecordTemplate);

            for (int i = 0; i < ct.text.Length / words[0].Length; ++i) {
                keywordOccuranceRecord[ct.text.Substring(curIndex, words[0].Length)] = true;
                curIndex += words[0].Length;
            }

            bool allTrue = true;
            foreach (bool val in keywordOccuranceRecord.Values) 
                allTrue &= val;

            if (allTrue)
                goodTokens.Add(ct);

            curIndex = 0;
        }
        
        comboTokens = goodTokens;
        return;
    }

    // Works, but unneeded
    private void FilterOutTokensOfImproperLength(List<ComboToken> comboTokens, string[] words) 
    {
        int totalRequiredLength = 0;

        foreach (var word in words) 
            totalRequiredLength += word.Length;

        for (int i = 0; i < comboTokens.Count; ++i) 
            if (comboTokens[i].text.Length != totalRequiredLength)
                comboTokens.Remove(comboTokens[i]);

        return;
    }


    // Works
    private static List<ComboToken> MakeComboTokens(List<string> tokens, string[] words) 
    {
        List<ComboToken> returnTokens = new();
        string currentComboText = "";
        int currentIndex = 0;
        foreach (var token in tokens) 
        {
            bool isAKeyWord = false;
            foreach (var word in words) 
            {
                if (token == word)
                {
                    isAKeyWord = true;
                    currentComboText += token;
                    break;
                }
            }

            if (isAKeyWord)
                continue;

            if (currentComboText != "") 
            {
                returnTokens.Add(new ComboToken(currentIndex, currentComboText));
                currentIndex += currentComboText.Length + token.Length;

                currentComboText = "";
            } 
            else 
            {
                currentIndex += token.Length;
            }
        }

        if (currentComboText != "") 
        {
            returnTokens.Add(new ComboToken(currentIndex, currentComboText));
            currentIndex += currentComboText.Length;
        }

        return returnTokens;
    }    

    // Without doing this, words which are a subset of others (e.g. [th, the]) may tokenize strangely.
    private static List<string> SortWordsByLengthDescending(string[] words) 
    {
        List<string> wordList = new List<string>(words);
        wordList.Sort((string string1, string string2) => {
            return string1.Length > string2.Length ? -1 : 1;
            });
        return wordList;
    }

    private List<string> TokenizeInputString(string input, string[] keywords) 
    {
        throw new NotImplementedException();
        // List<string> tokens = new();

        // int wordSize = keywords[0].Length;

        // string tempToken = "";

        // for (char c in input) 
        // {
        //     if (tempToken < word)
        // }

        // return tokens;
    }
}


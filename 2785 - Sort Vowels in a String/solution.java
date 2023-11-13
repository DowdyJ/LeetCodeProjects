class Solution {
    public String sortVowels(String s) {
        HashSet<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        Queue<Character> consonantsQueue = new LinkedList<>();
        Queue<Character> vowelsQueue = new PriorityQueue<>();

        for (int i = 0; i < s.length(); ++i) {
            if (vowels.contains(s.charAt(i))) {
                vowelsQueue.offer(s.charAt(i));
            }
            else {
                consonantsQueue.offer(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); ++i) {
            if (vowels.contains(s.charAt(i))) {
                sb.append(vowelsQueue.poll());
            }
            else {
                sb.append(consonantsQueue.poll());
            }
        }

        return sb.toString();
        
    }
}

public class Palindrome {
    /**
     * Given a String word, wordToDeque should return a Deque where the
     * characters appear in the same order as in the String
     * @param word to be parsed to a deque
     * @return Deque contains chars in String follow exact order
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    /**
     * if String word is palindrome return true; else return false
     * @param word to be tested if a palindrome
     * @return whether the word is a palindrome
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        while (deque.size() > 1) {
            if (!cc.equalChars(deque.removeLast(), deque.removeFirst())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        while (deque.size() > 1) {
            if (deque.removeLast() != deque.removeFirst()) {
                return false;
            }
        }
        return true;
    }
}

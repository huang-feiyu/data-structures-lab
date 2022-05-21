import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    /* partition strategy:
       1. str.length <= 1
       2. str.length > 1 and str is Palindrome
       3. str.length > 1 and str is NOT Palindrome
     */
    @Test
    public void testIsPalindrome() {
        // cover 1
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        // cover 2
        assertTrue(palindrome.isPalindrome("aaaabaaaa"));
        // cover 3
        assertFalse(palindrome.isPalindrome("ilikecat"));
    }
}

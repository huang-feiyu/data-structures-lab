import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    /* partition strategy:
       1. two chars that are off by one
       2. two chars that are not off by one
     */
    @Test
    public void testEqualChars() {
        // cover 1
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('&', '%'));
        // cover 2
        assertFalse(offByOne.equalChars('a', 'B'));
    }

    /* partition strategy:
       1. str.length <= 1
       2. str.length > 1 and str is Palindrome
       3. str.length > 1 and str is NOT Palindrome
     */
    @Test
    public void testIsPalindrome() {
        OffByOne obo = new OffByOne();
        // cover 1
        assertTrue(obo.isPalindrome(""));
        assertTrue(obo.isPalindrome("a"));
        // cover 2
        assertTrue(obo.isPalindrome("flake"));
        // cover 3
        assertFalse(obo.isPalindrome("flakasdf"));
    }
}

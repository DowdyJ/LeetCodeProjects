package dev.sugaroflead;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testCase1() {
        assertTrue(true);
        App a = new App();
        assertEquals(3, a.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void testCase2() {
        App a = new App();
        assertEquals(1, a.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void testCase3() {
        App a = new App();
        assertEquals(3, a.lengthOfLongestSubstring("pwwkew"));
    }    

    @Test
    public void testCase4() {
        App a = new App();
        assertEquals(3, a.lengthOfLongestSubstring("dvdf"));
    }
    
}


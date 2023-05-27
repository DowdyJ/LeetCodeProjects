package dev.sugaroflead;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AppTest 
{
    @Test
    public void testCase1() {
        App a = new App();
        boolean balanced = a.isValid("()");
        assertTrue(balanced);
    }

    @Test
    public void testCase2() {
        App a = new App();
        boolean balanced = a.isValid("()[]{}");
        assertTrue(balanced);
    }

    @Test
    public void testCase3() {
        App a = new App();
        boolean balanced = a.isValid("(]");
        assertFalse(balanced);
    }

    @Test
    public void testCase4() {
        App a = new App();
        boolean balanced = a.isValid("(])");
        assertFalse(balanced);
    }

    @Test
    public void testCase5() {
        App a = new App();
        boolean balanced = a.isValid("[");
        assertFalse(balanced);
    }
}

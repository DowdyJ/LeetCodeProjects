package dev.sugaroflead;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        App a = new App();
        assertEquals(47, a.myAtoi("47"));
    }

    public void testSpaceNegative() {
        App a = new App();
        assertEquals(-42, a.myAtoi("   -42"));
    }

    public void testWithWords() {
        App a = new App();
        assertEquals(4193, a.myAtoi("4193 with words"));
    }

    public void testWithWordsAtBeginning() {
        App a = new App();
        assertEquals(0, a.myAtoi("words and 987"));
    }

    public void testDecimal() {
        App a = new App();
        assertEquals(3, a.myAtoi("3.14159"));
    }

    public void testTooManyPlusSigns() {
        App a = new App();
        assertEquals(0, a.myAtoi(" ++1"));
    }

    public void testTooManyNegativeSigns() {
        App a = new App();
        assertEquals(0, a.myAtoi(" --1"));
    }
}

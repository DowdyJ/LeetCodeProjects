package dev.sugaroflead;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void testCase1() {
        App a = new App();
        String romanNumber = a.intToRoman(3);
        assertEquals("III", romanNumber);
    }

    @Test
    public void testCase2() {
        App a = new App();
        String romanNumber = a.intToRoman(58);
        assertEquals("LVIII", romanNumber);
    }

    @Test
    public void testCase3() {
        App a = new App();
        String romanNumber = a.intToRoman(1994);
        assertEquals("MCMXCIV", romanNumber);
    }
}

package dev.sugaroflead;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void testCase1()
    {
        App a = new App();
        double odds = a.new21Game(10, 1, 10);
        assertEquals(1.0000, odds, 0.00001);
    }

    @Test
    public void testCase2()
    {
        App a = new App();
        double odds = a.new21Game(6, 1, 10);
        assertEquals(0.60000, odds, 0.00001);
    }

    @Test
    public void testCase3()
    {
        App a = new App();
        double odds = a.new21Game(21, 17, 10);
        assertEquals(0.73278, odds, 0.00001);
    }
}

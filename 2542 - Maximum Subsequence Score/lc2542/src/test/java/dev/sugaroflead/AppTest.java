package dev.sugaroflead;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testCase1()
    {
        App a = new App();
        long max = a.maxScore(new int [] {1,3,3,2}, new int[] {2,1,4,3}, 3);
        assertEquals(12, max);
    }

    @Test
    public void testCase2()
    {
        App a = new App();
        long max = a.maxScore(new int [] {4,2,3,1,1}, new int[] {7,5,10,9,6}, 1);
        assertEquals(30, max);
    }
}

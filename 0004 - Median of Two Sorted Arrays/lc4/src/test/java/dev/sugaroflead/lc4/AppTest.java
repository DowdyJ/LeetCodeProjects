package dev.sugaroflead.lc4;

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
        double ans = a.findMedianSortedArrays(new int[] {1,3}, new int[] {2});
        assertEquals(2.00, ans, 0.00001);
    }

    @Test
    public void testCase2()
    {
        App a = new App();
        double ans = a.findMedianSortedArrays(new int[] {1,2}, new int[] {3,4});
        assertEquals(2.50, ans, 0.00001);
    }
}

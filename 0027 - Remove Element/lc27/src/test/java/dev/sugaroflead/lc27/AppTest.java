package dev.sugaroflead.lc27;

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
        int ans = a.removeElement(new int[] {3,2,2,3}, 3);
        assertEquals(2, ans);
    }

    @Test
    public void testCase2()
    {
        App a = new App();
        int ans = a.removeElement(new int[] {0,1,2,2,3,0,4,2}, 2);
        assertEquals(5, ans);
    }
}

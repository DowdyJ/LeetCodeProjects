package dev.sugaroflead.lc1376;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void testCase1()
    {
        App a = new App();
        int result = a.numOfMinutes(1, 0, new int[] {-1}, new int[] {0});
        assertEquals(0, result);
    }

    @Test
    public void testCase2()
    {
        App a = new App();
        int result = a.numOfMinutes(6, 2, new int[] {2,2,-1,2,2,2}, new int[] {0,0,1,0,0,0});
        assertEquals(1, result);
    }
}

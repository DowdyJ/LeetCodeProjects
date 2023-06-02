package dev.sugaroflead.lc2101;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class AppTest 
{

    @Test
    public void testCase1()
    {
        App a = new App();
        int ans = a.maximumDetonation(new int[][] {{2,1,3},{6,1,4}});
        assertEquals(2, ans);
    }

    //[1,1,5],[10,10,5]
    @Test
    public void testCase2()
    {
        App a = new App();
        int ans = a.maximumDetonation(new int[][] {{1,1,5},{10,10,5}});
        assertEquals(1, ans);
    }

    @Test
    public void testCase3()
    {
        App a = new App();
        int ans = a.maximumDetonation(new int[][] {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}});
        assertEquals(5, ans);
    }
}

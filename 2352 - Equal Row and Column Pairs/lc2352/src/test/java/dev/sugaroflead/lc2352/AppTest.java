package dev.sugaroflead.lc2352;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class AppTest 
{
    @Test
    public void testCase1()
    {
        App a = new App();
        int res = a.equalPairs(new int[][] {
            {3,2,1},
            {1,7,6},
            {2,7,7}});
        assertEquals(1, res);
    }

    @Test
    public void testCase2()
    {
        App a = new App();
        int res = a.equalPairs(new int[][] {
            {3,1,2,2},
            {1,4,4,5},
            {2,4,2,2},
            {2,4,2,2}});
        assertEquals(3, res);
    }


    @Test
    public void testCase3()
    {
        App a = new App();
        int res = a.equalPairs(new int[][] {
            {11,1},
            {1,11}});

        assertEquals(2, res);
    }
}

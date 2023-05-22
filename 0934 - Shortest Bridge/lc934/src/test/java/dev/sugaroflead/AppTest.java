package dev.sugaroflead;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCase1()
    {
        App a = new App();
        int ans = a.shortestBridge(new int[][] {
            {0, 1}, 
            {1, 0}});
        assertEquals(1, ans);
    }

    @Test
    public void testCase2() {
        App a = new App();
        int ans = a.shortestBridge(new int[][] {
            {0,1,0},
            {0,0,0},
            {0,0,1}});
        assertEquals(2, ans);
    }

    @Test
    public void testCase3() {
        App a = new App();
        int ans = a.shortestBridge(new int[][] {
            {1,1,1,1,1},
            {1,0,0,0,1},
            {1,0,1,0,1},
            {1,0,0,0,1},
            {1,1,1,1,1}});
        assertEquals(1, ans);        
    }

    @Test
    public void testCase4() {
        App a = new App();
        int ans = a.shortestBridge(new int[][] {
            {0,1,0,0,0},
            {0,1,0,1,1},
            {0,0,0,0,1},
            {0,0,0,0,0},
            {0,0,0,0,0}
        });
        assertEquals(1, ans); 
    
    }
}

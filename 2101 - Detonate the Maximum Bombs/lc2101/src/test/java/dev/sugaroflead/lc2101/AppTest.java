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

    @Test
    public void testCase4() {
        App a = new App();
        int ans = a.maximumDetonation(new int[][] {{656,619,56},{189,402,178},{513,373,276},{900,510,14},{188,173,129},{512,178,251},{145,685,47},{504,355,500},{554,131,214},{596,1,98},{358,230,197},{88,758,155},{72,340,419},{818,708,222}});
        assertEquals(14, ans);
    }
}

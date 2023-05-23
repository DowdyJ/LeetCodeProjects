package dev.sugaroflead;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testCase1() {
        App a = new App();
        int[] ans = a.topKFrequent(new int[] {1,1,1,2,2,3}, 2);
        int sum = 0;
        for (int i : ans)
            sum += i;
        assertEquals(3, sum);
    }

    @Test
    public void testCase2() {
        App a = new App();
        int[] ans = a.topKFrequent(new int[] {1}, 1);
        assertEquals(1, ans[0]);
    }

    @Test
    public void testCase3() {
        //[3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6]
        App a = new App();
        int[] ans = a.topKFrequent(new int[] {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6}, 10);
        
        int sum = 0;
        for (int i : ans)
            sum += i;

        assertEquals(57, sum);
    
    }
}

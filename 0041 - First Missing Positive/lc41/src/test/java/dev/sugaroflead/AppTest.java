package dev.sugaroflead;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    // Input: nums = [1,2,0]
    // Output: 3
    @Test
    public void testCase1()
    {
        App a = new App();
        int ans = a.firstMissingPositive(new int[] {1,2,0});
        assertEquals(3, ans);
    }

    //Input: nums = [3,4,-1,1]
    //Output: 2
    @Test
    public void testCase2()
    {
        App a = new App();
        int ans = a.firstMissingPositive(new int[] {3,4,-1,1});
        assertEquals(2, ans);
    }

    //Input: nums = [7,8,9,11,12]
    //Output: 1
    @Test
    public void testCase3()
    {
        App a = new App();
        int ans = a.firstMissingPositive(new int[] {7,8,9,11,12});
        assertEquals(1, ans);
    }

    //0,2,2,1,1
    //output 3
    @Test
    public void testCase4() {
        App a = new App();
        int ans = a.firstMissingPositive(new int[] {0,2,2,1,1});
        assertEquals(3, ans);
    }
}


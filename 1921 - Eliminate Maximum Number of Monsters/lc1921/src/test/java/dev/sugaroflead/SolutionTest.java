package dev.sugaroflead;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SolutionTest {
    //Input: dist = [1,3,4], speed = [1,1,1]
    //Output: 3
    @Test
    public void testCase1() {
        Solution s = new Solution();
        assertEquals(3, s.eliminateMaximum(new int[] {1,3,4}, new int[] {1,1,1}));
    }

    //Input: dist = [1,1,2,3], speed = [1,1,1,1]
    //Output: 1
    @Test
    public void testCase2() {
        Solution s = new Solution();
        assertEquals(1, s.eliminateMaximum(new int[] {1,1,2,3}, new int[] {1,1,1,1}));
    }
    
    //Input: dist = [3,2,4], speed = [5,3,2]
    //Output: 1
    @Test
    public void testCase3() {
        Solution s = new Solution();
        assertEquals(1, s.eliminateMaximum(new int[] {3,2,4}, new int[] {5,3,2}));
    }
}

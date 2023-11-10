package dev.sugaroflead;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void testCase1() {
        Solution s = new Solution();
        int[] val = s.restoreArray(new int[][] {{2,1},{3,4},{3,2}});
        assertArrayEquals(new int[] {1,2,3,4}, val);
    }

    @Test
    public void testCase2() {
        Solution s = new Solution();
        int[] val = s.restoreArray(new int[][] {{4,-2},{1,4},{-3,1}});
        assertArrayEquals(new int[] {-2,4,1,-3}, val);
    }

    @Test
    public void testCase3() {
        Solution s = new Solution();
        int[] val = s.restoreArray(new int[][] {{-10000,10000}});
        assertArrayEquals(new int[] {10000, -10000}, val);
    }
}

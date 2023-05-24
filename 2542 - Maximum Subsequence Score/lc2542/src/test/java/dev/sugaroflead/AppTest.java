package dev.sugaroflead;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{


    @Test
    public void testSort1()
    {
        App a = new App();
        int[] arr1 = new int [] {2,1,14,12};
        int[] arr2 = new int[] {11,7,13,6};
        a.quickSort(arr2, arr1, 0, 3);
        
        // System.out.println("ARR1");
        // for (int num : arr1)
        //     System.out.println(num);
        
        // System.out.println("ARR2");
        // for (int num : arr2)
        //     System.out.println(num);
        
        assertEquals(6, arr2[0]);
        assertEquals(7, arr2[1]);
        assertEquals(11, arr2[2]);
        assertEquals(13, arr2[3]);
    }    

    @Test
    public void testCase1()
    {
        App a = new App();
        long max = a.maxScore(new int [] {1,3,3,2}, new int[] {2,1,4,3}, 3);
        assertEquals(12, max);
    }

    @Test
    public void testCase2()
    {
        App a = new App();
        long max = a.maxScore(new int [] {4,2,3,1,1}, new int[] {7,5,10,9,6}, 1);
        assertEquals(30, max);
    }

    @Test
    public void testCase3()
    {
        App a = new App();
        long max = a.maxScore(new int [] {1,4}, new int[] {3,1}, 2);
        assertEquals(5, max);
    }

    @Test
    public void testCase4()
    {
        App a = new App();
        long max = a.maxScore(new int [] {2,1,14,12}, new int[] {11,7,13,6}, 3);
        assertEquals(168, max);
    }
}

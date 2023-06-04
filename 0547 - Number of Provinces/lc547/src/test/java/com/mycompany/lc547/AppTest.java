package com.mycompany.lc547;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class AppTest 
{
    @Test
    public void testCase1()
    {
        App a = new App();
        int result = a.findCircleNum(new int[][] {{1,1,0}, {1,1,0}, {0,0,1}});

        assertEquals(2, result);
    }

    @Test
    public void testCase2()
    {
        App a = new App();
        int result = a.findCircleNum(new int[][] {{1,0,0}, {0,1,0}, {0,0,1}});

        assertEquals(3, result);
    }
}

package dev.sugaroflead.lc7;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testCase1()
    {
        App a = new App();
        int res = a.reverse(-123);
        assertEquals(-321, res);
    }

    @Test
    public void testCase2()
    {
        App a = new App();
        int res = a.reverse(123);
        assertEquals(321, res);
    }

    @Test
    public void testCase3()
    {
        App a = new App();
        int res = a.reverse(120);
        assertEquals(21, res);
    }

    @Test
    public void testCase4()
    {
        App a = new App();
        int res = a.reverse(1);
        assertEquals(1, res);
    }

    @Test
    public void testCase5()
    {
        App a = new App();
        int res = a.reverse(901000);
        assertEquals(109, res);
    }

    @Test
    public void testCase6()
    {
        App a = new App();
        //1056389759
        //1534236469
        int res = a.reverse(1534236469);
        assertEquals(0, res);
    }
}

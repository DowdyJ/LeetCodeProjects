package dev.sugaroflead.lc6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AppTest 
{

    @Test
    public void test1()
    {
        App a = new App();
        String res = a.convert("PAYPALISHIRING", 3);
        assertEquals("PAHNAPLSIIGYIR", res);
    }

    @Test
    public void test2()
    {
        App a = new App();
        String res = a.convert("PAYPALISHIRING", 4);
        assertEquals("PINALSIGYAHRPI", res);
    }
}

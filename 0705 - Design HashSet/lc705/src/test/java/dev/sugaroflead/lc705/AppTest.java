package dev.sugaroflead.lc705;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import dev.sugaroflead.lc705.MyHashSet;
/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void testCase1()
    {
        MyHashSet hs = new MyHashSet();
        assertFalse(hs.contains(401));
        hs.add(401);
        assertTrue( hs.contains(401) );

        assertFalse(hs.contains(95));
        hs.add(95);
        assertTrue( hs.contains(95) );
        hs.remove(95);
        assertFalse(hs.contains(95));
    }
}

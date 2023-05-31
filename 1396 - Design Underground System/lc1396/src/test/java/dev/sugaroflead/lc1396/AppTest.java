package dev.sugaroflead.lc1396;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        UndergroundSystem u = new UndergroundSystem();

        u.checkIn(45,"Leyton",3);
        u.checkIn(32,"Paradise",8);
        u.checkIn(27,"Leyton",10);

        u.checkOut(45,"Waterloo",15);
        u.checkOut(27,"Waterloo",20);
        u.checkOut(32,"Cambridge",22);
        
        assertEquals(14, u.getAverageTime("Paradise","Cambridge"), 0.0001);
        assertEquals(11, u.getAverageTime("Leyton", "Waterloo"), 0.0001);
        u.checkIn(10,"Leyton",24);
        assertEquals(11, u.getAverageTime("Leyton", "Waterloo"), 0.0001);
        u.checkOut(10,"Waterloo",38);
        assertEquals(12, u.getAverageTime("Leyton", "Waterloo"), 0.0001);
    }
}

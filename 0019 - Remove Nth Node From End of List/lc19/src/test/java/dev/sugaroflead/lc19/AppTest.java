package dev.sugaroflead.lc19;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void test1()
    {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        App a = new App();
        ListNode res = a.removeNthFromEnd(n1, 2);

        assertEquals(1, res.val);
        assertEquals(2, res.next.val);
        assertEquals(3, res.next.next.val);
        assertEquals(5, res.next.next.next.val);
    }
}

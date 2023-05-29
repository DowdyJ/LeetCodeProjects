package dev.sugaroflead.lc21;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        ListNode cur = new ListNode();        
        ListNode dummyHead = cur;
        
        boolean usingList1 = list1.val < list2.val;

        for(; list1 != null || list2 != null; ) {
            cur.next = new ListNode(usingList1 ? list1.val : list2.val);
            cur = cur.next;

            if (usingList1)
                list1 = list1.next;
            else
                list2 = list2.next;

            if (list1 == null)
                usingList1 = false;
            else if (list2 == null)
                usingList1 = true;
            else 
                usingList1 = list1.val < list2.val;

        }

        return dummyHead.next;
    }
}



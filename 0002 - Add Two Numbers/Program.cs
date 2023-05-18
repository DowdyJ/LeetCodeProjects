/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curNode = null;

        bool carryOver = false;

        while (l1 is not null || l2 is not null) 
        {
            int val1 = (l1?.val ?? 0);
            int val2 = (l2?.val ?? 0);

            if (carryOver) 
                val1++;

            int sum = val1 + val2;
            carryOver = sum > 9;
            
            if (head is null) 
            {
                head = new ListNode(sum % 10, null);
                curNode = head; 
            }
            else 
            {
                curNode.next = new ListNode(sum % 10, null);
                curNode = curNode.next;
            }

            l1 = l1?.next;
            l2 = l2?.next;
        }

        if (carryOver)
            curNode.next = new ListNode(1, null); 

        return head;

    }
}
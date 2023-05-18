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
    public int PairSum(ListNode head) {
        int numberOfNodes = 0;

        ListNode curNode = head;
        while (curNode != null) 
        {
            ++numberOfNodes;
            curNode = curNode.next;
        }

        curNode = head;

        Stack<int> firstHalf = new Stack<int>();
        Queue<int> lastHalf = new Queue<int>();

        int curNodeIndex = 0;
        while (curNodeIndex < numberOfNodes/2) 
        {
            firstHalf.Push(curNode.val);
            curNode = curNode.next;
            ++curNodeIndex;
        }

        while (curNode != null) 
        {
            lastHalf.Enqueue(curNode.val);
            curNode = curNode.next;
        }

        int maxSum = -1;

        while (firstHalf.Count > 0) 
        {
            int sum = lastHalf.Dequeue() + firstHalf.Pop();
            if (sum > maxSum)
                maxSum = sum;
        }
        


        return maxSum;
    }
}
package dev.sugaroflead.lc19;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class App 
{
    public static void main (String[] args) {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        App a = new App();
        ListNode res = a.removeNthFromEnd(n1, 2);
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curNode = head;

        Deque<ListNode> lastNNodes = new ArrayDeque<ListNode>();
        int nodeCount = 0;

        while (curNode != null) {
            lastNNodes.offer(curNode);

            if (lastNNodes.size() > n + 1)
                lastNNodes.pop();

            curNode = curNode.next;
            nodeCount++;
        }

        if (nodeCount == 1)
            return null;

        if (nodeCount - n == 0)
            return head.next;
        

        for (int i = 0; i < n - 2; ++i) {
            lastNNodes.pollLast();
        }


        if (n == 1) {
            lastNNodes.pollLast();
            lastNNodes.pollLast().next = null;
        }
        else {
            ListNode stichTo = lastNNodes.pollLast();
            lastNNodes.pollLast();
            lastNNodes.pollLast().next = stichTo;
        }

        return head;
    }
}

 

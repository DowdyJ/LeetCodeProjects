package dev.sugaroflead;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    int inspectionIndex = -1;
    static Comparator<Integer> orderAscending = new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
            if (i1 == i2)
                return 0;
            else if (i1 < i2)
                return -1;

            return 1;
        }
    };

    Queue<Integer> values = new PriorityQueue<>(orderAscending);

    public KthLargest(int k, int[] nums) {
        this.inspectionIndex = k;
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (values.size() == inspectionIndex && val < values.peek())
            return values.peek();

        values.offer(val);

        if (values.size() > inspectionIndex)
            values.poll();

        return values.peek();
    }
}

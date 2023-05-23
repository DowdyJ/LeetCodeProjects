package dev.sugaroflead;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    ArrayList<Integer> values = new ArrayList<>();

    public KthLargest(int k, int[] nums) {
        this.inspectionIndex = k;
        for (int num : nums) {
            values.add(num);
        }

        Collections.sort(values, orderAscending);
    }
    
    public int add(int val) {
        values.add(val);
        Collections.sort(values, orderAscending);
        return values.get(values.size() - inspectionIndex);
    }
}

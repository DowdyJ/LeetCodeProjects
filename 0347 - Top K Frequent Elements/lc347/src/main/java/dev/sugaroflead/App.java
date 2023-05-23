package dev.sugaroflead;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map.Entry;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        App a = new App();
        int[] p = a.topKFrequent(new int[] {1,1,1,2,2,3}, 2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> valueToOccuranceFrequency = new HashMap<>();

        for (int num : nums) {
            valueToOccuranceFrequency.put(num, valueToOccuranceFrequency.getOrDefault(num, 0) + 1);
        }

        int[] topKeys = new int[k];
        int numberOfSelectedKeys = 0;

        Queue<Map.Entry<Integer, Integer>> sortedEntries = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                if (e1.getValue() == e2.getValue())
                    return 0;
                else if (e1.getValue() > e2.getValue())
                    return -1;
                
                return 1;
            }
        });

        for (Map.Entry<Integer, Integer> entry : valueToOccuranceFrequency.entrySet()) {
            sortedEntries.add(entry);
        }

        while (numberOfSelectedKeys < k) {
            topKeys[numberOfSelectedKeys] = sortedEntries.poll().getKey();
            numberOfSelectedKeys++;
        }

        return topKeys;
    }
}

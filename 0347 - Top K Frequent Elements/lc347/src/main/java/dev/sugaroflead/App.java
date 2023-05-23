package dev.sugaroflead;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
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

        ArrayList<Integer> values = new ArrayList<>(valueToOccuranceFrequency.values());
        
        Collections.sort(values, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i1.compareTo(i2); // sort descending;
            } 
        });

        ArrayList<Integer> topKeys = new ArrayList<>();
        int numberOfSelectedKeys = 0;
        while (numberOfSelectedKeys < k) {
            int currentHighestValue = -1; 

            do {
                currentHighestValue = values.remove(values.size() - 1);
            } while (values.size() != 0 && currentHighestValue == values.get(values.size() - 1));

            for (Map.Entry<Integer, Integer> entry : valueToOccuranceFrequency.entrySet()) {
                if (entry.getValue() == currentHighestValue) {
                    topKeys.add(entry.getKey());
                    numberOfSelectedKeys++;

                    if (numberOfSelectedKeys >= k)
                        break;
                }
            }
        }

        int[] p = topKeys.stream().mapToInt(i -> i).toArray();

        return p;
    }
}

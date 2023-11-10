package dev.sugaroflead;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {
    class NumberNode {
        public Integer neighbor1;
        public Integer neighbor2;
        public Integer value;
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        Map<Integer, NumberNode> numbers = new HashMap<>();

        for (int[] pair : adjacentPairs) {

            if (seenNumbers.contains(pair[0])) {
                numbers.get(pair[0]).neighbor2 = pair[1];
                seenNumbers.remove(pair[0]);
            }
            else {
                NumberNode nn1 = new NumberNode();
                nn1.value = pair[0];
                nn1.neighbor1 = pair[1];
                numbers.put(pair[0], nn1);

                seenNumbers.add(pair[0]);
            }

            if (seenNumbers.contains(pair[1])) {
                numbers.get(pair[1]).neighbor2 = pair[0];
                seenNumbers.remove(pair[1]);
            }
            else {
                NumberNode nn2 = new NumberNode();
                nn2.value = pair[1];
                nn2.neighbor1 = pair[0];
                numbers.put(pair[1], nn2);

                seenNumbers.add(pair[1]);
            }
        }

        List<Integer> restoredList = new ArrayList<>();
        Iterator<Integer> iter = seenNumbers.iterator();
        Integer first = iter.next();
        Integer last = iter.next();

        NumberNode currentNode = numbers.get(first);
        Integer lastNodeValue = null;

        while (!currentNode.value.equals(last)) {
            restoredList.add(currentNode.value);

            int prev = currentNode.value;

            if (lastNodeValue == null || lastNodeValue.equals(currentNode.neighbor2)) {
                currentNode = numbers.get(currentNode.neighbor1);
            }
            else {
                currentNode = numbers.get(currentNode.neighbor2);
            }            
            
            lastNodeValue = prev;
        }

        restoredList.add(last);

        return restoredList.stream().mapToInt(Integer::intValue).toArray();
    }
}

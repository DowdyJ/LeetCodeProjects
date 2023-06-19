package dev.sugaroflead.lc414;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args )
    {
        App a = new App();
        int res = a.thirdMax(new int[] {-2147483648,-2147483648,-2147483648,-2147483648,1,1,1});
        System.out.println( res );
    }

    public int thirdMax(int[] nums) {

        Queue<Integer> maxScores = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                if (i1 == i2)
                    return 0;
                else if (i2 < i1)
                    return -1;
                
                return 1;
            }
        });
        maxScores.addAll(Arrays.stream( nums ).boxed().collect( Collectors.toList()));

        int maxVal = maxScores.peek();

        Integer lastRemovedVal = null;
        int numberOfRemovedVals = 0;

        while (numberOfRemovedVals < 3 && !maxScores.isEmpty()) {
            if (lastRemovedVal != null && maxScores.peek().equals(lastRemovedVal)) {
                maxScores.poll();
                continue;
            }

            lastRemovedVal = maxScores.poll();
            numberOfRemovedVals++;
        }

        if (numberOfRemovedVals == 3)
            return lastRemovedVal;
        else
            return maxVal;
    }
}

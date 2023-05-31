package dev.sugaroflead.lc15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


        App a = new App();
        List<List<Integer>> res = a.threeSum(new int[] {0,0,0});

        for (List<Integer> set : res) {
            System.out.println("Answer: ");
            for (Integer i : set) {
                System.out.print(i + ", ");
            }
            System.out.print('\n');
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Set<Integer> numSet = new HashSet<Integer>();
        Set<Integer> negNumSet = new HashSet<Integer>();
        Set<Integer> posNumSet = new HashSet<Integer>();

        Set<List<Integer>> answerSet = new HashSet<>();
        
        for (int i : nums) {
            if (numSet.contains(i))
                continue;

            if (i < 0) {
                negNumSet.add(i);
            }
            else if (i > 0) {
                posNumSet.add(i);
            }

            numSet.add(i);
        }


        if (numSet.contains(0)) {
            addTripleZeroIfExist(nums, answerSet);
            addZeroInclusiveLists(numSet, posNumSet, negNumSet, answerSet);
            numSet.remove(0);
        }
                
        addTripletLists(nums, posNumSet, negNumSet, answerSet);

        return new ArrayList<>(answerSet);
        
    }

    private void addTripleZeroIfExist(int[] nums, Set<List<Integer>> answerSet) {
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0)
                zeroCount++;
        }

        if (zeroCount >= 3) {
            List<Integer> entry = new ArrayList<Integer>();
            entry.add(0);
            entry.add(0);
            entry.add(0);

            answerSet.add(entry);
        }
    }

    private void addZeroInclusiveLists(Set<Integer> numSet, Set<Integer> posNumSet, Set<Integer> negNumSet, Set<List<Integer>> answerSet) {

        for (Integer num : posNumSet) {

            if (negNumSet.contains(-num)) {
                List<Integer> entry = new ArrayList<Integer>();
                entry.add(-num);
                entry.add(0);
                entry.add(num);

                if (!answerSet.contains(entry)) {
                    answerSet.add(entry);
                }
            }
        }

        return;
    }

    private void addTripletLists(int[] nums, Set<Integer> posNumSet, Set<Integer> negNumSet, Set<List<Integer>> answerSet) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length && nums[nums.length - 1 - i] > 0; ++i) {
            int currentBase = nums[nums.length - 1 - i];

            for (int j = i + 1; j < nums.length && nums[nums.length - 1 - j] > 0; ++j) {
                if (negNumSet.contains(-1*(currentBase + nums[nums.length - 1 - j]))) {
                    List<Integer> entry = new ArrayList<Integer>();
                    entry.add(-1*(currentBase + nums[nums.length - 1 - j]));
                    entry.add(nums[nums.length - 1 - j]);
                    entry.add(currentBase);

                    if (!answerSet.contains(entry)) {
                        answerSet.add(entry);
                    }
                }
            }
        }

        for (int i = 0; i < nums.length && nums[i] < 0; ++i) {
            int currentBase = nums[i];

            for (int j = i + 1; j < nums.length && nums[j] < 0; ++j) {
                if (posNumSet.contains(-1*(currentBase + nums[j]))) {
                    List<Integer> entry = new ArrayList<Integer>();
                    entry.add(currentBase);
                    entry.add(nums[j]);
                    entry.add(-1*(currentBase + nums[j]));

                    if (!answerSet.contains(entry)) {
                        answerSet.add(entry);
                    }
                }
            }
        }
    } 
}

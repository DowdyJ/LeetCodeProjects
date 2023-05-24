package dev.sugaroflead;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        long maxScore = 0;

        if (nums1.length == k) {
            long result = 0;
            for (int num : nums1)
                result += num;

            int minMult = Integer.MAX_VALUE;
            for (int num : nums2) 
                minMult = num < minMult ? num : minMult;

            result *= minMult;
            return result;
        }


        quickSort(nums2, nums1, 0, nums1.length - 1);

        int currentInspectionIndex = nums1.length - k;

        Queue<Integer> topAdditiveNumbers = new PriorityQueue<>(k);
        
        // Initialize the heap with first full set of values
        for (int i = currentInspectionIndex; i < nums1.length; ++i) {
            topAdditiveNumbers.offer(nums1[i]);
        }

        while (currentInspectionIndex >= 0) {
            int currentMultiplier = nums2[currentInspectionIndex];

            topAdditiveNumbers.offer(nums1[currentInspectionIndex]);
            topAdditiveNumbers.poll();

            long sum = 0;

            for (int entry : topAdditiveNumbers)
                sum += entry;

            long product = sum * currentMultiplier;
            
            if (product > maxScore)
                maxScore = product;

            currentInspectionIndex--;
        }

        return maxScore;
    }

    public void quickSort(int[] arrayToSort, int[] collateralToSort, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arrayToSort, collateralToSort, low, high);

            quickSort(arrayToSort, collateralToSort, low, partitionIndex -1);
            quickSort(arrayToSort, collateralToSort, partitionIndex + 1, high);
        }
    }

    private int partition(int[] arrayToSort, int[] collateralToSort, int low, int high) {
        int pivot = arrayToSort[high];

        int insertionIndex = low - 1;

        for (int i = low; i < high; ++i) {
            if (arrayToSort[i] <= pivot) {
                insertionIndex++;

                int temp = arrayToSort[insertionIndex];
                arrayToSort[insertionIndex] = arrayToSort[i];
                arrayToSort[i] = temp;

                temp = collateralToSort[insertionIndex];
                collateralToSort[insertionIndex] = collateralToSort[i];
                collateralToSort[i] = temp;
            }
        }

        insertionIndex++;

        int temp = arrayToSort[insertionIndex];
        arrayToSort[insertionIndex] = arrayToSort[high];
        arrayToSort[high] = temp;

        temp = collateralToSort[insertionIndex];
        collateralToSort[insertionIndex] = collateralToSort[high];
        collateralToSort[high] = temp;

        return insertionIndex;
    }

}

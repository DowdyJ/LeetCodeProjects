package dev.sugaroflead;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        long startTime = System.nanoTime();
        App a = new App();
        long max = a.maxScore(new int [] {2,1,14,12,2,1,14,12,2,1,14,12,2,1,14,12,2,1,14,12,2,1,14,12,2,1,14,12,2,1,14,12,2,1,14,12,2,1,14,12,2,1,14,12,2,1,14,12,2,1,14,12,2,1,14,12,2,1,14,12}, new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 3);
        long endTime = System.nanoTime();

        System.out.println("TOTAL: " + (endTime - startTime));
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


        // if (isPoorMatchForQuickSort(nums2))
        //     altSort(nums2, nums1);
        // else
        quickSort(nums2, nums1, 0, nums1.length - 1);

        int currentInspectionIndex = nums1.length - k;

        Queue<Integer> topAdditiveNumbers = new PriorityQueue<>(k);
        
        // Initialize the heap with first full set of values
        for (int i = currentInspectionIndex + 1; i < nums1.length; i++) {
            topAdditiveNumbers.offer(nums1[i]);
        }

        long sum = 0;
        int previousSmallestNumber = -1;

        while (currentInspectionIndex >= 0) {
            
            if ((topAdditiveNumbers.peek() == null ? 0 : topAdditiveNumbers.peek()) <= nums1[currentInspectionIndex] || topAdditiveNumbers.size() < k) {

                int currentMultiplier = nums2[currentInspectionIndex];

                topAdditiveNumbers.offer(nums1[currentInspectionIndex]);
                if (topAdditiveNumbers.size() > k)
                    previousSmallestNumber = topAdditiveNumbers.poll();
                
                if (sum == 0) {
                    for (int entry : topAdditiveNumbers)
                        sum += entry;
                }   
                else {
                    sum -= previousSmallestNumber;
                    sum += nums1[currentInspectionIndex];
                }
    
                long product = sum * currentMultiplier;
                if (product > maxScore)
                    maxScore = product;
            }

            currentInspectionIndex--;
        }

        return maxScore;
    }

    public void quickSort(int[] arrayToSort, int[] collateralToSort, int low, int high) {
        if (low < high) {
            int[] partitionIndices = partition(arrayToSort, collateralToSort, low, high);
            quickSort(arrayToSort, collateralToSort, low, partitionIndices[0] - 1);
            quickSort(arrayToSort, collateralToSort, partitionIndices[1] + 1, high);
        }
    }
    
    private int[] partition(int[] arrayToSort, int[] collateralToSort, int low, int high) {
        int pivot = arrayToSort[high];
        int i = low, lt = low, gt = high;
    
        while(i <= gt) {
            if(arrayToSort[i] < pivot) {
                swap(arrayToSort, collateralToSort, lt++, i++);
            } else if(arrayToSort[i] > pivot) {
                swap(arrayToSort, collateralToSort, i, gt--);
            } else {
                i++;
            }
        }
    
        return new int[] {lt, gt};
    }
    
    private void swap(int[] arrayToSort, int[] collateralToSort, int i, int j) {
        int temp = arrayToSort[i];
        arrayToSort[i] = arrayToSort[j];
        arrayToSort[j] = temp;
    
        temp = collateralToSort[i];
        collateralToSort[i] = collateralToSort[j];
        collateralToSort[j] = temp;
    }

}

package dev.sugaroflead;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        nums = Arrays.stream(nums).filter(i -> i > 0).toArray();
        int firstMissing = 1;
        int lastVal = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (lastVal == nums[i])
                continue;

            lastVal = nums[i];
            
            if (nums[i] != firstMissing) {
                return firstMissing;
            }
            firstMissing++;
        }
        return firstMissing;
    }
}

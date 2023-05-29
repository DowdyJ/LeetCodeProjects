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
        App a = new App();
        int[] input = new int[] {2,1,0,5,6,3,-1};
        input = Arrays.stream(input).filter(i -> i > 0).toArray();

        for (int i = 0; i < input.length; ++i) {
            a.shredArray(input, input[i]);
        }
        
        for (int num : input) {
            System.out.println(num);
        }
    }

    public int firstMissingPositive(int[] nums) {
        nums = Arrays.stream(nums).filter(i -> i > 0).toArray();

        for (int i = 0; i < nums.length; ++i) {
            shredArray(nums, nums[i]);
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0)
                return i + 1;
        }

        return nums.length + 1;
    }

    public void shredArray(int[] nums, int nextIndex) {

        if (nextIndex < 1 || nextIndex > nums.length)
            return;

        int temp = nums[nextIndex - 1];
        if (temp == -1)
            return;

        nums[nextIndex - 1] = -1;
        shredArray(nums, temp);
    }
}

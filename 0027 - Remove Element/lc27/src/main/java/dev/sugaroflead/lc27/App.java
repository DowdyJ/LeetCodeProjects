package dev.sugaroflead.lc27;

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

    public int removeElement(int[] nums, int val) {
        int digitsToReturn = nums.length;

        for (int i = 0; i < digitsToReturn; ++i) {
            if (nums[i] != val)
                continue;

            int temp = nums[i];
            nums[i] = nums[digitsToReturn - 1];
            nums[digitsToReturn - 1] = temp;
            digitsToReturn--;
            i--;
        }

        return digitsToReturn;
    }
}

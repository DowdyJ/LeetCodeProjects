package dev.sugaroflead.lc26;

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

    public int removeDuplicates(int[] nums) {
        int lastVal = -101;
        int numberToReturn = nums.length;

        for (int i = 0; i < numberToReturn; ++i) {
            if (nums[i] != lastVal) {
                lastVal = nums[i];
                continue;
            }
            
            nums[i] = nums[i + 1];
            
            --numberToReturn;
        }


        return numberToReturn;
    }
}

package dev.sugaroflead.lc4;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combinedArray = new int[nums1.length + nums2.length];

        int nums1Index = 0;
        int nums2Index = 0;

        boolean nums1Finished = nums1.length == 0;
        boolean nums2Finished = nums2.length == 0;

        for (int i = 0; i < combinedArray.length; ++i) {

            if (nums2Finished || (!nums1Finished && nums1[nums1Index] < nums2[nums2Index])) {
                combinedArray[i] = nums1[nums1Index++];

                if (!nums1Finished && nums1Index > nums1.length - 1)
                    nums1Finished = true;
            } else {
                combinedArray[i] = nums2[nums2Index++];

                if (!nums2Finished && nums2Index > nums2.length - 1)
                    nums2Finished = true;
            }
        }

        if (combinedArray.length % 2 == 0) {
            int upperMedianIndex = combinedArray.length / 2;
            return ((double)combinedArray[upperMedianIndex - 1] + (double)combinedArray[upperMedianIndex]) / 2;
        } else {
            return combinedArray[combinedArray.length / 2];
        }
    }
}

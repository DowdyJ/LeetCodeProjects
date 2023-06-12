using System.Collections.Generic;
using System.Text;

public class Solution {

    public static int Main(string[] args) {
        Solution a = new();
        IList<string> strings = a.SummaryRanges(new int[] {0,2,3,4,6,8,9});
        foreach (string s in strings) {
            Console.WriteLine(s);
        }
        // 0
        // 2->4
        // 6
        // 8->9
        return 0;
    }


    public IList<string> SummaryRanges(int[] nums) {
        IList<string> result = new List<string>();

        if (nums.Length == 0)
            return result;

        int? firstNum = null;
        int? lastNum = null;

        for (int expectedVal = nums[0], numIndex = 0; numIndex < nums.Length; ++expectedVal, ++numIndex) {
            if (firstNum is null) {
                firstNum = nums[numIndex];
                continue;
            }

            if (nums[numIndex] != expectedVal) {

                if (lastNum is null || firstNum >= lastNum) {
                    result.Add($"{firstNum}");
                }
                else {
                    result.Add($"{firstNum}->{lastNum}");
                }

                expectedVal = nums[numIndex];

                numIndex--;
                expectedVal--;

                firstNum = null;
                lastNum = null;
            }

            lastNum = nums[numIndex];
        }

        if (lastNum is null || firstNum >= lastNum) {
            result.Add($"{firstNum}");
        }
        else {
            result.Add($"{firstNum}->{lastNum}");
        }


        return result;
    }
}
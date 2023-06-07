
using System.Collections;

public class Solution {
    public int[] TwoSum(int[] nums, int target) {

        Hashtable numSet = new Hashtable();

        for (int i = 0; i < nums.Length; ++i) 
        {   
            if (numSet.ContainsKey(nums[i])) {
                continue;
            }
            numSet.Add(nums[i], i);
        }
        int solution1Index = 0;
        int solution2Index = 0;

        if (GetIndexOfDupicateValue(numSet, nums, target) is int ans && ans != -1)
        {
            //throw new Exception();
            solution1Index = (int)numSet[target/2];
            solution2Index = ans;  
            return new int[] {solution1Index, solution2Index};
        } else 
        {
            if (numSet.ContainsKey(target/2))
                numSet.Remove(target/2);
        }



        for (int i = 0; i < nums.Length; ++i)
        {
            int keyValue = target - nums[i];
            if (numSet.ContainsKey(keyValue)) 
            {   
                solution1Index = i;
                solution2Index = (int)numSet[keyValue];
                break;
            }
        }

        return new int[] {solution1Index, solution2Index};
    }

    static int GetIndexOfDupicateValue(Hashtable table, int[] nums, int target) 
    {
        int dupIndex = -1;
        int halfValue = target / 2;
        if (table.ContainsKey(halfValue))
        {
            for (int i = ((int)table[halfValue]) + 1; i < nums.Length; ++i) 
            {
                if (nums[i] == halfValue) 
                {
                    dupIndex = i;
                    break;
                }   
            }
        }
        return dupIndex;
    }
}
# @param {Integer[]} nums
# @return {Integer[]}
def apply_operations(nums)
    nums.each_with_index {|val, index|
        if index + 1 < nums.length && val == nums[index + 1]
            nums[index] = 2 * val;
            nums[index + 1] = 0;
        end
    }

    numsNew = []
    numsNew.concat(nums.select { |n| n > 0 })

    (0..nums.length - numsNew.length - 1).each {
        numsNew << 0
    }

    numsNew
end


puts apply_operations([1,2,2,1,1,0])
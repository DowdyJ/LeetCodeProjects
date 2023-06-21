# @param {Integer[]} nums
# @return {Integer}
def array_pair_sum(nums)
    nums.sort!
    result = 0
    switch = true
    nums.each { |val|
        if (switch)
            result += val
        end

        switch = !switch
    }

    result
end
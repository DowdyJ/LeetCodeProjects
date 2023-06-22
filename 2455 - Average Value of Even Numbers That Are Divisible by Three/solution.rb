# @param {Integer[]} nums
# @return {Integer}
def average_value(nums)
    nums.select! { |num| num % 6 == 0 }
    return 0 if nums.count == 0
    nums.sum / nums.count
end
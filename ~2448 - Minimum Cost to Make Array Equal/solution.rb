require 'set'

# @param {Integer[]} nums
# @param {Integer[]} cost
# @return {Integer}
def min_cost(nums, cost)
    costs = []

    nums.each_with_index { |value, index|
        curCost = 0
        (0..nums.length - 1).each { |subIndex|
            curCost += (value - nums[subIndex]).abs * cost[subIndex]
        }

        costs[index] = curCost
    }

    costs.min
end


puts min_cost([1,3,5,2], [2,3,1,14])
puts min_cost([2,2,2,2,2], [4,2,8,1,3])

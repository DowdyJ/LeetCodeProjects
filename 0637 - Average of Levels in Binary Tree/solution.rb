
class TreeNode
    attr_accessor :val, :left, :right
    def initialize(val = 0, left = nil, right = nil)
        @val = val
        @left = left
        @right = right
    end
end


def average_of_one_level(node, levelIndex, resultSum, resultCount)
    return if node == nil
    
    if resultSum.length < levelIndex + 1
        resultSum << 0
    end

    resultSum[levelIndex] += node.val

    if resultCount.length < levelIndex + 1
        resultCount << 0
    end

    resultCount[levelIndex] += 1

    average_of_one_level(node.left, levelIndex + 1, resultSum, resultCount)
    average_of_one_level(node.right, levelIndex + 1, resultSum, resultCount)
end

# @param {TreeNode} root
# @return {Float[]}
def average_of_levels(root)
    resultSum = []
    resultCount = []

    average_of_one_level(root, 0, resultSum, resultCount)

    resultSum.each_index { |index| resultSum[index] /= resultCount[index].to_f }
    resultSum
end
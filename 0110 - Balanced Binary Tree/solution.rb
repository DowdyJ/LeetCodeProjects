# Definition for a binary tree node.
class TreeNode
    attr_accessor :val, :left, :right
    def initialize(val = 0, left = nil, right = nil)
        @val = val
        @left = left
        @right = right
    end
end


def DFS(node, depth)
    return depth if node == nil
    result = [DFS(node.left, depth + 1), -1 * DFS(node.right, depth + 1)]
    return -1 if result.sum.abs > 1 || result[0] == -1 || result[1] == 1
    result[1] *= -1
    result.max
end

def is_balanced(root)
    return true if root == nil
    val1 = DFS(root.left, 0)
    val2 = DFS(root.right, 0)
    (val1 - val2).abs <= 1 && val1 != -1 && val2 != -1
end

r2 = TreeNode.new(3, nil, nil)
r1 = TreeNode.new(2, nil, r2)
head = TreeNode.new(0, nil, r1)

puts is_balanced(head)

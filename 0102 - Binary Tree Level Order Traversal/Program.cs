using System.Collections.Generic;

namespace lc101;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public IList<IList<int>> LevelOrder(TreeNode root) {
        Queue<TreeNode> nodeQueue = new Queue<TreeNode>();

        nodeQueue.Enqueue(root);

        IList<IList<int>> result = new List<IList<int>>();
        

        while (nodeQueue.Count > 0) {
            IList<int> curResult = new List<int>();

            int count = nodeQueue.Count;

            for (int i = 0; i < count; ++i) {
                TreeNode cur = nodeQueue.Dequeue();
                if (cur is null)
                    continue;

                curResult.Add(cur.val);
                nodeQueue.Enqueue(cur.left);
                nodeQueue.Enqueue(cur.right);
            }
            
            if (curResult.Count > 0)
                result.Add(curResult);
        }

        return result;
    }
}
package dev.sugaroflead.lc530;

import java.util.concurrent.atomic.AtomicInteger;

public class App 
{
    public static void main( String[] args )
    {

    }

    public int getMinimumDifference(TreeNode root) {
        
        AtomicInteger minimumDifference = new AtomicInteger(Integer.MAX_VALUE);

        DFS(root.left, minimumDifference, null, root.val);
        DFS(root.right, minimumDifference, root.val, null);

        return minimumDifference.get();
    }

    private void DFS(TreeNode curNode, AtomicInteger minimumDifference, Integer lower, Integer upper) {
        if (curNode == null)
            return;

        int diff1;
        int diff2;

        if (lower != null) 
            diff1 = Math.abs(curNode.val - lower);
        else
            diff1 = Integer.MAX_VALUE;

        if (upper != null) 
            diff2 = Math.abs(curNode.val - upper);
        else
            diff2 = Integer.MAX_VALUE;

        minimumDifference.set(Math.min(Math.min(diff1, diff2), minimumDifference.get()));

        DFS(curNode.left, minimumDifference, lower, curNode.val);
        DFS(curNode.left, minimumDifference, curNode.val, upper);
    }

}

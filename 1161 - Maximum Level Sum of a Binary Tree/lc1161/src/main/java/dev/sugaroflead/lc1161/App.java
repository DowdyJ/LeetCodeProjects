package dev.sugaroflead.lc1161;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class App 
{
    List<AtomicInteger> layerSums = new ArrayList<>();

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        TreeNode n6 = new TreeNode(-8);
        TreeNode n5 = new TreeNode(7);
        TreeNode n4 = new TreeNode(7, n5, n6);
        TreeNode n3 = new TreeNode(0);
        TreeNode n2 = new TreeNode(1, n4, n3);

        App a = new App();
        int res = a.maxLevelSum(n2);

    }

    public int maxLevelSum(TreeNode root) {

        DFS(root, 0);
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < this.layerSums.size(); ++i) {
            if (this.layerSums.get(i).get() > maxValue) {
                maxValue = this.layerSums.get(i).get();
                maxIndex = i;
            }
        }

        return maxIndex + 1;
    }

    void DFS(TreeNode curNode, int curLevel) {

        if (curNode == null)
            return;

        if (layerSums.size() <= curLevel) {
            layerSums.add(new AtomicInteger(0));
        }

        layerSums.get(curLevel).addAndGet(curNode.val);

        DFS(curNode.left, curLevel + 1);
        DFS(curNode.right, curLevel + 1);
    }
}

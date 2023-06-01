package dev.sugaroflead.lc1091;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        App a = new App();
        int ans = a.shortestPathBinaryMatrix(new int[][] {{0,1},{1,0}});
        //assertEquals(2, ans);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1)
            return -1;

        int result = 0;

        Queue<Integer[]> neighborNodes = new LinkedList<Integer[]>() {};
        neighborNodes.offer(new Integer[] {0, 0});

        boolean[][] seenNodes = new boolean[grid.length][grid.length];

        while(!neighborNodes.isEmpty()) {

            int oldSize = neighborNodes.size();

            for (int i = 0; i < oldSize; ++i) {
                Integer[] coords = neighborNodes.poll();
                
                if (coords[0] == grid.length - 1 && coords[1] == grid[0].length - 1)
                    return ++result;

                addValidNeighbors(grid, coords[0], coords[1], seenNodes, neighborNodes);
            }

            result++;
        }

        return -1;
    }

    private void addValidNeighbors(int[][] grid, int x, int y, boolean[][] seenNodes, Queue<Integer[]> neighbors)  {
        int[][] dirs = new int[][] {{1,0}, {1,1}, {0,1}, {-1,1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};

        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (areIndecesInBounds(grid, newX, newY) && grid[newX][newY] != 1 && !seenNodes[newX][newY]) {
                neighbors.offer(new Integer[] {newX, newY});
                seenNodes[newX][newY] = true;
            }
        }
    }

    private boolean areIndecesInBounds(int[][] grid, int x, int y) {
        return !(x < 0 || y < 0 || y >= grid.length || x >= grid.length);
    }
}

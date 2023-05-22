package dev.sugaroflead;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public int shortestBridge(int[][] grid) {
        int answer = 0;
        int[] islandTwoBlock = new int[] {};
        boolean islandOneFound = false;
        boolean islandTwoFound = false;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (!islandOneFound && grid[i][j] == 1) {
                    islandOneFound = true;
                    DFS(grid, i, j);
                }

                if (islandOneFound && grid[i][j] == 1) {
                    islandTwoBlock = new int[] {i, j};
                    islandTwoFound = true;
                    break;
                }
            }
            if (islandTwoFound)
                break;
        }

        answer = BFS(grid, islandTwoBlock[0], islandTwoBlock[1]);

        return answer;
    }

    private void DFS(int[][] grid, int i, int j) {
        if (i > grid.length - 1 || i < 0 || j > grid[0].length - 1 || j < 0 || grid[i][j] == 0 || grid[i][j] == 2)
            return;

        grid[i][j] = 2;

        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
    }

    private int BFS(int[][] grid, int i, int j) {
        int solution = 0;

        Queue<int[]> bfsQueue = new LinkedList<int[]>();
        bfsQueue.offer(new int[] {i, j});

        while (!bfsQueue.isEmpty()) {
            int oldQueueSize = bfsQueue.size();

            for (int k = 0; k < oldQueueSize; ++k) {
                int[] currentNode = bfsQueue.remove();
                grid[currentNode[0]][currentNode[1]] = 4;
                if (currentNode[0] + 1 < grid.length && grid[currentNode[0] + 1][currentNode[1]] == 2 ||
                    (currentNode[0] - 1 >= 0 && grid[currentNode[0] - 1][currentNode[1]] == 2) ||
                    (currentNode[1] + 1 < grid[0].length && grid[currentNode[0]][currentNode[1] + 1] == 2) ||
                    (currentNode[1] - 1 >= 0 && grid[currentNode[0]][currentNode[1] - 1] == 2)) {
                    
                    return solution;
                } else {

                    if (currentNode[0] + 1 <= grid.length - 1 && 
                        currentNode[1] <= grid.length - 1 && 
                        currentNode[1] >= 0 && 
                        currentNode[0] + 1 >= 0 && 
                        grid[currentNode[0] + 1][currentNode[1]] != 4) 
                    {
                        bfsQueue.offer(new int[] {currentNode[0] + 1, currentNode[1]});
                    }
                    else if (
                        currentNode[0] - 1 <= grid.length - 1 && 
                        currentNode[1] <= grid.length - 1 && 
                        currentNode[1] >= 0 && currentNode[0] - 1 >= 0 && 
                        grid[currentNode[0] - 1][currentNode[1]] != 4) 
                    {
                        bfsQueue.offer(new int[] {currentNode[0] - 1, currentNode[1]});
                    }
                    else if (
                        currentNode[0] <= grid.length - 1 && 
                        currentNode[1] + 1 <= grid.length - 1 && 
                        currentNode[1] + 1 >= 0 && 
                        currentNode[0] >= 0 && 
                        grid[currentNode[0]][currentNode[1] + 1] != 4) 
                    {
                        bfsQueue.offer(new int[] {currentNode[0], currentNode[1] + 1});
                    }
                    else if (
                        currentNode[0] <= grid.length - 1 && 
                        currentNode[1] -1 <= grid.length - 1 && 
                        currentNode[1] -1 >= 0 && 
                        currentNode[0] >= 0 && 
                        grid[currentNode[0]][currentNode[1] - 1] != 4) 
                    {
                        bfsQueue.offer(new int[] {currentNode[0], currentNode[1] - 1});                        
                    }


                }
            }

            solution++;
        }

        return solution;
    }
}

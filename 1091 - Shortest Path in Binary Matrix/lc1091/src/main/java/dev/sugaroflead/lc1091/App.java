package dev.sugaroflead.lc1091;

import java.util.ArrayDeque;
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
        gridLength = grid.length;

        if (gridLength < 255)
            return processSmallGrids(grid);
        else
            return processNormalGrids(grid);

    }


    public int processSmallGrids(int[][] grid) {
        if (gridLength == 0 || grid[0][0] == 1 || grid[gridLength - 1][gridLength - 1] == 1)
            return -1;

        int result = 0;
        // Initialized to inital size of just above best case scenario diagonal path
        Queue<char[]> neighborNodes = new ArrayDeque<char[]>((int)(1.5 * gridLength)) {};
        neighborNodes.offer(new char[] {0, 0});

        char[] coords;
        int oldSize;
        int newX;
        int newY;

        while(!neighborNodes.isEmpty()) {
            
            oldSize = neighborNodes.size();
            
            for (int i = 0; i < oldSize; ++i) {
                coords = neighborNodes.poll();
                
                if (coords[0] == gridLength - 1 && coords[1] == grid[0].length - 1)
                    return ++result;
        
                for (byte[] dir : dirs) {
                    newX = coords[0] + dir[0];
                    newY = coords[1] + dir[1];
                    if (!(newX < 0 || newY < 0 || newY >= gridLength || newX >= gridLength) && grid[newX][newY] != 1) {
                        neighborNodes.offer(new char[] {(char)newX, (char)newY});
                        grid[newX][newY] = 1;
                    }
                }
            }

            result++;
        }

        return -1;
    }

    public int processNormalGrids(int[][] grid) {
        if (gridLength == 0 || grid[0][0] == 1 || grid[gridLength - 1][gridLength - 1] == 1)
            return -1;

        int result = 0;
        // Initialized to inital size of just above best case scenario diagonal path
        Queue<int[]> neighborNodes = new ArrayDeque<int[]>((int)(1.5 * gridLength)) {};
        neighborNodes.offer(new int[] {0, 0});

        int[] coords;
        int oldSize;
        int newX;
        int newY;

        while(!neighborNodes.isEmpty()) {
            
            oldSize = neighborNodes.size();
            
            for (int i = 0; i < oldSize; ++i) {
                coords = neighborNodes.poll();
                
                if (coords[0] == gridLength - 1 && coords[1] == grid[0].length - 1)
                    return ++result;
        
                for (byte[] dir : dirs) {
                    newX = coords[0] + dir[0];
                    newY = coords[1] + dir[1];
                    if (!(newX < 0 || newY < 0 || newY >= gridLength || newX >= gridLength) && grid[newX][newY] != 1) {
                        neighborNodes.offer(new int[] {newX, newY});
                        grid[newX][newY] = 1;
                    }
                }
            }

            result++;
        }

        return -1;
    }

    int gridLength = 0;
    
    static final byte[][] dirs = new byte[][] {{1,0}, {1,1}, {0,1}, {-1,1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
}

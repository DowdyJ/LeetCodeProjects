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
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean found = false;
        for(int i=0;i<grid.length;i++){
            if(found) break;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    DFS(grid, i, j, queue, visited);
                    found = true;
                    break;
                }
            }
        }
        return BFS(queue, visited, grid);
    }
    
    private void DFS(int[][] grid, int i, int j, Queue<int[]> queue, boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || grid[i][j] == 0) 
            return;
    
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        DFS(grid, i+1, j, queue, visited);
        DFS(grid, i-1, j, queue, visited);
        DFS(grid, i, j+1, queue, visited);
        DFS(grid, i, j-1, queue, visited);
    }
    
    private int BFS(Queue<int[]> queue, boolean[][] visited, int[][] grid){
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int[] curr = queue.poll();
                for(int[] dir:dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || visited[x][y]) continue;
    
                    if(grid[x][y] == 1) return distance;
    
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
            distance++;
        }
        return -1;
    }
    
}

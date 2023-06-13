package dev.sugaroflead.lc2352;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    Map<String, AtomicInteger> entryToCountColumn = new HashMap<>();
    Map<String, AtomicInteger> entryToCountRow = new HashMap<>();

    public int equalPairs(int[][] grid) {
        makeColumnMap(grid);
        makeRowMap(grid);

        int matches = 0;

        for (Map.Entry<String, AtomicInteger> entry : entryToCountColumn.entrySet()) {

            if (!entryToCountRow.containsKey(entry.getKey()))
                continue;

            matches += entry.getValue().get() * entryToCountRow.get(entry.getKey()).get();
        }

        return matches;
    }

    private void makeColumnMap(int[][] grid) {
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                key.append(grid[i][j]);
                key.append('-');
            }
            String keyString = key.toString();
            if (entryToCountColumn.containsKey(keyString))
                entryToCountColumn.get(keyString).incrementAndGet();
            else
                entryToCountColumn.put(keyString, new AtomicInteger(1));

            key = new StringBuilder();
        }

        return;
    }

    private void makeRowMap(int[][] grid) {
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                key.append(grid[j][i]);
                key.append('-');
            }
            String keyString = key.toString();
            if (entryToCountRow.containsKey(keyString))
                entryToCountRow.get(keyString).incrementAndGet();
            else
                entryToCountRow.put(keyString, new AtomicInteger(1));

            key = new StringBuilder();
        }

        return;
    }

}


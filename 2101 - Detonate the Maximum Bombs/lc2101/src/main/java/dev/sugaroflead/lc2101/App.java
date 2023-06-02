package dev.sugaroflead.lc2101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.Painter;

public class App 
{
    public class Pair <K,V> {
        public Pair(K x, V y) {
            this.key = x;
            this.value = y;
        }

        K key;
        V value;

        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }

        @Override
        public final boolean equals(Object other) {

            if (!(other instanceof Pair<?,?>))
                return false;

            final Pair<?,?> otherPair = (Pair<?,?>)other;

            return otherPair.key.equals(this.key) && otherPair.value.equals(this.value);
        }

        @Override
        public final int hashCode() {
            return this.key.hashCode() + this.value.hashCode();
        }
    }


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        App a = new App();
        int ans = a.maximumDetonation(new int[][] {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}});
        //assertEquals(5, ans);
    }

    public int maximumDetonation(int[][] bombs) {
        if (bombs.length == 1)
            return 1;

        // tile x,y -> bomb index list
        Map<Pair<Integer, Integer>, List<Integer>> bombMap = new HashMap<>(bombs.length);  
        
        for (int[] bomb : bombs) {
            bombMap.put(new Pair<Integer, Integer>(bomb[0], bomb[1]), new ArrayList<Integer>());
        }

        for (int bombIndex = 0; bombIndex < bombs.length; ++bombIndex) {
            for (int[] blownCell : getExplosionCells(bombs[bombIndex])) {
                Pair<Integer, Integer> currentCell = new Pair<Integer,Integer>(blownCell[0], blownCell[1]);
                if (bombMap.containsKey(currentCell))
                    bombMap.get(currentCell).add(bombIndex);
            }
        }

        Set<Integer> blownBombs;
        ArrayList<Integer> results = new ArrayList<>();
        int[] singleResult = new int[] {0};
        for (int i = 0; i < bombs.length; ++i) {
            blownBombs = new HashSet<>();
            singleResult[0] = 0;
            DFS(bombMap, bombs, blownBombs, singleResult, i);
            results.add(singleResult[0]);
        }

        int biggestBombChain = 0;

        for (int result : results) {
            if (result > biggestBombChain)
                biggestBombChain = result;
        }

        return biggestBombChain;
    }


    public void DFS(Map<Pair<Integer, Integer>, List<Integer>> bombMap, int[][] bombs, Set<Integer> blownBombs, int[] count, int bombIndex) {
        if (blownBombs.contains(bombIndex))
            return;

        blownBombs.add(bombIndex);
        count[0]++;

        for (int neighbor : bombMap.get(new Pair<Integer,Integer>(bombs[bombIndex][0], bombs[bombIndex][1]))) {
            DFS(bombMap, bombs, blownBombs, count, neighbor);
        }
    }


    public ArrayList<int[]> getExplosionCells(int[] bomb) {
        int radius = bomb[2];

        if (radius <= 0)
            return new ArrayList<int[]>();

        ArrayList<int[]> results = new ArrayList<>();

        for (int y = bomb[1] - radius; y < bomb[1] + radius; y++) {
            for (int x = bomb[0] - radius; x < bomb[0] + radius; x++) {
                if (x < 0 || y < 0)
                    continue;

                if (Math.sqrt(Math.pow((x - bomb[0]),2) + Math.pow((y - bomb[1]), 2)) <= radius) {
                    results.add(new int[] {x, y});
                }
            }    
        }


        return results;
    }
}

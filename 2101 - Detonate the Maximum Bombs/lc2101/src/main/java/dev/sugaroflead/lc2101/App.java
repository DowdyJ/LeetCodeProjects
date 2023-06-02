package dev.sugaroflead.lc2101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App 
{

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        App a = new App();

        int ans1 = a.maximumDetonation(new int[][] {{2,1,3},{6,1,4}});

        int ans = a.maximumDetonation(new int[][] {{1,1,100000},{100000,100000,1}});
        System.out.println("Answer: " + ans);
        //assertEquals(5, ans);
    }

    public class Pair <K,V> {
        public Pair(K x, V y) {
            this.key = x;
            this.value = y;
        }

        K key;
        V value;

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

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


    public int maximumDetonation(int[][] bombs) {
        if (bombs.length == 1)
            return 1;

        // tile x,y -> bomb index list
        Map<Pair<Integer, Integer>, List<Integer>> bombMap = new HashMap<>(bombs.length);  
        
        for (int[] bomb : bombs) {
            bombMap.put(new Pair<Integer, Integer>(bomb[0], bomb[1]), new ArrayList<Integer>());
        }

        Pair<Integer, Integer> currentCell = new Pair<Integer,Integer>(null, null);
        for (int bombIndex = 0; bombIndex < bombs.length; ++bombIndex) {
            int[] bomb = bombs[bombIndex];
            for (int otherBombIndex = 0; otherBombIndex < bombs.length; ++otherBombIndex) {
                if (otherBombIndex == bombIndex)
                    continue;

                int[] otherBomb = bombs[otherBombIndex];
                if (Math.pow((otherBomb[0] - bomb[0]), 2) + Math.pow((otherBomb[1]-bomb[1]),2) <= Math.pow(bomb[2], 2)) {
                    currentCell.setKey(otherBomb[0]);
                    currentCell.setValue(otherBomb[1]);
                    bombMap.get(currentCell).add(bombIndex);
                }
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


    public Integer TLEGuard() {
        return 0;
    }
}

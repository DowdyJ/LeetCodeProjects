package dev.sugaroflead;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        Queue<Float> timeToArrive = new PriorityQueue<>(dist.length);

        for (int i = 0; i < dist.length; ++i) {
            timeToArrive.offer((float)dist[i] / (float)speed[i]);
        }


        int currentTime = 1;
        timeToArrive.poll();

        while (!timeToArrive.isEmpty() && currentTime < timeToArrive.poll()) {
            currentTime++;
        }

        return currentTime;
    }
}
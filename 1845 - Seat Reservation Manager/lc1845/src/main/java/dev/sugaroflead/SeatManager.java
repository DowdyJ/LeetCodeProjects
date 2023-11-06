package dev.sugaroflead;


import java.util.PriorityQueue;
import java.util.Queue;

public class SeatManager {


    Queue<Integer> availableSeats;

    public SeatManager(int n) {
        this.availableSeats = new PriorityQueue<>();
        
        for (int i = 1; i <= n; ++i) {
            this.availableSeats.offer(i);
        }
    }
    
    public int reserve() {
        return this.availableSeats.poll();
    }
    
    public void unreserve(int seatNumber) {
        this.availableSeats.offer(seatNumber);
    }
}

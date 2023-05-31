package dev.sugaroflead.lc1396;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.List;
import java.util.Map;
//import java.util.Set;

public class UndergroundSystem {

    public class Pair <K,V> {
        public Pair(K stationName, V timeTaken) {
            this.key = stationName;
            this.value = timeTaken;
        }

        K key;
        V value;

        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }

    private Map<String, List<Pair<String, Integer>>> stationsAndTimes = new HashMap<>();

    private Map<Integer, Pair<String, Integer>> idToCheckinTime = new HashMap<>();


    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        idToCheckinTime.put(id, new Pair<String, Integer>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> data = idToCheckinTime.get(id);
        idToCheckinTime.remove(id);

        List<Pair<String, Integer>> existingData = stationsAndTimes.get(stationName);
        
        if (existingData == null) {
            existingData = new ArrayList<>();
            stationsAndTimes.put(stationName, existingData);
        }

        existingData.add(new Pair<String, Integer>(data.getKey(), t - data.getValue()));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int count = 0;
        int total = 0;
        
        for (Pair<String, Integer> data : stationsAndTimes.get(endStation)) {
            if (data.getKey().equals(startStation)) {
                count++;
                total += data.getValue();
            }
        }

        if (count == 0)
            return 0;

        return (double)total/(double)count;
    }
}



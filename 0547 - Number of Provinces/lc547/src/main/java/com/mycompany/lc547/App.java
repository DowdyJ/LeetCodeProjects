package com.mycompany.lc547;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }


    public class City {
        public City() {
            this.neighbors = new ArrayList<City>();
            this.id = -1;
        }
        int id;
        List<City> neighbors;
    }

    public int findCircleNum(int[][] isConnected) {
        City[] cityGraph = new City[isConnected.length];
        for (int i = 0; i < cityGraph.length; ++i)
            cityGraph[i] = new City();

        buildGraph(cityGraph, isConnected);

        return getNumberOfProvinces(cityGraph, isConnected);
    }

    private int getNumberOfProvinces(City[] cityGraph, int[][] isConnected) {
        int result = 0;
        
        Set<Integer> visitedCityIds = new HashSet<>(isConnected.length);
        for (City c : cityGraph) {

            if (!visitedCityIds.contains(c.id))
                result++;

            DFS(c, visitedCityIds);
        }

        return result;
    }

    private void DFS(City currentCity, Set<Integer> visitedCities) {
        if (visitedCities.contains(currentCity.id))
            return;

        visitedCities.add(currentCity.id);

        for (City neighbor : currentCity.neighbors) {
            DFS(neighbor, visitedCities);
        }
    }


    private void buildGraph(City[] cityGraph, int[][] isConnected) {
        for (int i = 0; i < isConnected.length; i ++) {
            City currentCity = cityGraph[i];
            currentCity.id = i;
            for (int j = 0; j < isConnected[i].length; ++j) {
                if (isConnected[i][j] == 1) {
                    currentCity.neighbors.add(cityGraph[j]);
                }
            } 
        }
    }
}

package com.graph.part03;

import java.util.Arrays;

public class P29_CityWithTheSmallestNumberOfNeighbors {

    /*
    There are n cities labeled from 0 to n-1 with m edges connecting them.
    Given the array edges where edges[i] = [fromi , toi ,weighti]  represents a bidirectional and weighted edge
    between cities from i and to i, and given the integer distanceThreshold.
    You need to find out a city with the smallest number of cities that are reachable through some
    path and whose distance is at most Threshold Distance. If there are multiple such cities,
    our answer will be the city with the greatest label.

    Note: The distance of a path connecting cities i and j is equal to the sum of the edge's weights along that path.
    **/

    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        // code here
        int [][] dist= new int[n][n];

        for(int i =0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i] = 0 ;
        }
        for(int i =0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            dist[u][v] = wt;
            dist[v][u] = wt;


        }



        for(int k =0;k<n;k++){
            for(int i =0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] < Integer.MAX_VALUE && dist[k][j] < Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }

        int countCity = n;
        int cityNo = -1;

        for(int i =0;i<n;i++){
            int temp =0;
            for(int j=0;j<n;j++){
                if(i != j && dist[i][j]<=distanceThreshold){
                    temp++;
                }
            }
            if(temp<=countCity){
                countCity = temp;
                cityNo =  i;
            }
        }
        return cityNo;
    }
}

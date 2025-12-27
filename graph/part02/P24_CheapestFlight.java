package com.graph.part02;

import com.graph.common.Pair;

import java.lang.reflect.Array;
import java.util.*;

public class P24_CheapestFlight {


    /*
    There are n cities and m edges connected by some number of flights.
    You are given an array flights where flights[i] = [fromi, toi, pricei]
        indicates that there is a flight from the city fromi to city toi with cost pricei.

    You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
    If there is no such route, return -1.
    Note: The price from city A to B may be different From the price from city B to A.
    * */

    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        // Code here

        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        //{u,v,wt}
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair<>(flights[i][1], flights[i][2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        //{dist, src, wt}
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(0, src, 0));

        dist[src] = 0;
        while (!queue.isEmpty()) {

            Tuple tp = queue.poll();

            int stopCount = tp.first;
            int node = tp.second;
            int wt = tp.third;
            if (stopCount > k) {
                continue;
            }
            for (int i = 0; i < adj.get(node).size(); i++) {

                int adjNode = adj.get(node).get(i).first;
                int adjWt = adj.get(node).get(i).second;

                if (wt + adjWt < dist[adjNode]) {
                    dist[adjNode] = wt + adjWt;
                    queue.offer(new Tuple(stopCount + 1, adjNode, dist[adjNode]));
                }

            }

        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

}

class Tuple {
    int first, second, third;

    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

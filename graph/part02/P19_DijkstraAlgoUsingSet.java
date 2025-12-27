package com.graph.part02;

import java.util.*;

public class P19_DijkstraAlgoUsingSet {

    /*
    Here we will be using the set data structure
    Here we erase already reach pair from  set  if we found the better path
    to remove it we invest the log n , so it can not improve the dijkstra algo

    In a TreeSet,two elements are considered duplicates if the comparator returns zero, not if equals() returns true.

    */

    public int[] getShortestPath(int V, List<List<List<Integer>>> edges, int S) {

        /*
        TreeSet<CustomPair> tree  = new TreeSet<>(
                (o1, o2) -> {
                    int cmp = o1.distance.compareTo(o2.distance);
                    if (cmp != 0) return cmp;
                    return o1.node.compareTo(o2.node);
                }
        );
        */
        TreeSet<CustomPair> tree  = new TreeSet<>(
                Comparator.comparingInt((CustomPair o) -> o.distance).thenComparingInt(o -> o.node)
        );

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        tree.add(new CustomPair(0, S));

        while (!tree.isEmpty()) {
            CustomPair customPair = tree.pollFirst();
            int u = customPair.node;
            int wt = customPair.distance;

            for (int i = 0; i < edges.get(u).size(); i++) {
                int adjNode = edges.get(u).get(i).get(0);
                int adjWeight = edges.get(u).get(i).get(1);

                if (wt + adjWeight < dist[adjNode]) {
                    // Remove old pair if exists
                    if(dist[adjNode] !=Integer.MAX_VALUE){
                        tree.remove(new CustomPair(dist[adjNode], adjNode));
                    }
                    // Update wt
                    dist[adjNode] = wt + adjWeight;

                    // Add new pair
                    tree.add(new CustomPair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }


    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<List<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // edges[i] = {u, v, w}
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            // u -> v
            List<Integer> e1 = new ArrayList<>();
            e1.add(v);
            e1.add(w);
            adj.get(u).add(e1);

            // v -> u (UNDIRECTED)
            List<Integer> e2 = new ArrayList<>();
            e2.add(u);
            e2.add(w);
            adj.get(v).add(e2);
        }

        return getShortestPath(V, adj, src);
    }
}

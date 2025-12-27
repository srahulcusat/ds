package com.graph.part02;

import java.util.*;

public class P18_DijkstraAlgo {

    /*

    Definition:
    Dijkstra’s Algorithm is a single-source shortest path algorithm used to find the minimum distance
    from a starting node to all other nodes in a weighted directed or undirected graph,
    only when edge weights are non-negative

       adj[u] = { {v1, w1}, {v2, w2} }
       By default, PriorityQueue is min-heap only but if u want to give custom comparator u can provide ,
       as give below based on requirement
       hear we wanted minimum distance first

       Dijkstra algo fail for negative DG

    */

    public int[] getShortestPath(int V, List<List<List<Integer>>> edges, int S) {
        PriorityQueue<CustomPair> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        queue.offer(new CustomPair(0, S));

        while (!queue.isEmpty()) {
            int distance = queue.peek().distance;
            int node = queue.peek().node;
            queue.poll();
            if (distance > dist[node]) continue;
            for (int i = 0; i < edges.get(node).size(); i++) {

                int adjNode = edges.get(node).get(i).get(0);
                int adjWeight = edges.get(node).get(i).get(1);

                if (distance + adjWeight < dist[adjNode]) {
                    dist[adjNode] = distance + adjWeight;
                    queue.offer(new CustomPair(dist[adjNode], adjNode));
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


class CustomPair {
    public Integer distance;
    public Integer node;

    public CustomPair(Integer distance, Integer node) {
        this.distance = distance;
        this.node = node;
    }
}



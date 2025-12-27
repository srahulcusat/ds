package com.graph.part03;

import com.graph.common.Pair;

import java.util.*;

public class P31_MinimumSpanningTree {

    /*
     Given a weighted, undirected, and connected graph with V vertices and E edges,
     your task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph.
     The graph is provided as a list of edges, where each edge is represented as [u, v, w],
     indicating an edge between vertex u and vertex v with edge weight w.

     A tree having n node and n-1 edges and all the nodes are reachable from each other

    */

    public int spanningTree(int V, int[][] edges) {
        //code here
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] ed : edges) {
            adj.get(ed[0]).add(new Pair<Integer, Integer>(ed[1], ed[2]));
            adj.get(ed[1]).add(new Pair<Integer, Integer>(ed[0], ed[2]));
        }

        // {wt, node, parent} -> if mst list is required , else {wt,node} is enough
        // hear wt is wt of parent to node only and not the total wt till now
        PriorityQueue<Tuple<Integer, Integer, Integer>> queue =
                new PriorityQueue<>(
                        Comparator.comparingInt((Tuple<Integer, Integer, Integer> x) -> x.first)
                                .thenComparingInt(x -> x.second)
                                .thenComparingInt(x -> x.third)
                );
        queue.offer(new Tuple<Integer, Integer, Integer>(0, 0, -1));

        List<Pair<Integer, Integer>> mst = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        int minWeight = 0;

        while (!queue.isEmpty()) {
            Tuple<Integer, Integer, Integer> tuple = queue.poll();
            int wt = tuple.first;
            int u = tuple.second;
            int parent = tuple.third;
            if (visited[u]) continue;
            visited[u] = true;
            if (parent != -1) {
                minWeight += wt;
                mst.add(new Pair<>(parent, u));
            }

            for (Pair<Integer, Integer> pair : adj.get(u)) {
                int nextNode = pair.first;
                int nextWt = pair.second;
                if (!visited[nextNode]) {
                    queue.offer(new Tuple<>(nextWt, nextNode, u)); // here insert the node to queue
                }
            }

        }
        System.out.println("MST Edges: " + mst);
        System.out.println("MST Weight: " + minWeight);
        return minWeight;
    }
}


class Tuple<F, S, T> {
    F first;
    S second;
    T third;

    Tuple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public String toString() {
        return "Pair{" + first + ", " + second + ", " + third + "}";
    }
}
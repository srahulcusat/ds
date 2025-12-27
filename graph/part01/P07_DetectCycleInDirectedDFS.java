package com.graph.part01;

import java.util.List;

public class P07_DetectCycleInDirectedDFS {

    //Detect cycle for directed graph using P02_DFS algorithm
    private boolean isCyclePresent(int src, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited) {

        visited[src] = true;
        pathVisited[src] = true;
        for (int ad : adj.get(src)) {
            if (!visited[ad]) {
                if (isCyclePresent(ad, adj, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[ad]) {
                return true;
            }
        }
        pathVisited[src] = false;
        return false;
    }


    private boolean cycleDFS(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclePresent(i, adj, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }
}

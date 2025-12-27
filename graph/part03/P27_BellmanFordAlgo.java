package com.graph.part03;

import java.util.Arrays;

public class P27_BellmanFordAlgo {

    /*
    Bellman–Ford Algorithm — Definition
    Bellman–Ford is a single-source shortest path algorithm used to compute the shortest distances
    from a source vertex to all other vertices in a weighted graph, even when negative edge weights exist.

    It works by relaxing all edges repeatedly for V − 1 iterations (where V = number of vertices).
    It also performs an extra iteration to detect the presence of a negative weight cycle — if a shorter
    path is still possible, then a negative cycle exists.
    Time complexity
    O(V × E)


    It can also:
    Detect negative weight cycles

    Question:

    Given a weighted graph with V vertices numbered from 0 to V-1 and E edges,
    represented by a 2d array edges[][],
    where edges[i] = [u, v, w] represents a direct edge from node u to v having w edge weight.
    You are also given a source vertex src.
    Your task is to compute the shortest distances from the source to all other vertices.
    If a vertex is unreachable from the source, its distance should be marked as 108.
    Additionally, if the graph contains a negative weight cycle, return [-1] to indicate that shortest paths cannot be reliably computed.

    */



    public int[] bellmanFord(int V, int[][] edges, int src) {

        //instead of storing like adjacent
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e8);
        dist[src]=0;

        for(int j=0;j<V-1;j++){
            for(int[] ed : edges){
                int u = ed[0];
                int v = ed[1];
                int wt = ed[2];

                if(dist[u]!=(int)1e8 && dist[u]+wt<dist[v]){
                    dist[v] = dist[u]+wt;
                }
            }
        }

        //iterate all the edges one more time to check if dist relax if not , than no negative cycle
        for(int[] ed : edges){
            int u = ed[0];
            int v = ed[1];
            int wt = ed[2];

            if(dist[u]!=(int)1e8 && dist[u]+wt<dist[v]){
                return  new int[]{-1};
            }
        }

        return dist;

    }
}

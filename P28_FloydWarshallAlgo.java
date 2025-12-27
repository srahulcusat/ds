package com.graph.part03;

public class P28_FloydWarshallAlgo {

    /*
    Floyd–Warshall Algorithm — Definition:

    Floyd–Warshall is an all-pairs shortest path algorithm used to compute the shortest distances
    between every pair of vertices in a weighted graph.

    It uses a Dynamic Programming approach and builds solutions by considering each vertex
    as an intermediate point between pairs of nodes.
    Works with negative weights, but if a negative weight cycle exists, shortest paths are not defined.
    O(V³)

    You are given a weighted directed graph, represented by an adjacency matrix, dist[][] of size n x n,
    where dist[i][j] represents the weight of the edge from node i to node j. If there is no direct edge, dist[i][j] is set to a large value (i.e., 108) to represent infinity.
    The graph may contain negative edge weights, but it does not contain any negative weight cycles.
    Your task is to find the shortest distance between every pair of nodes i and j in the graph.
    */


    /*
    The algorithm is not intuitive as other ones.It is more of a brute force,
    where all combination of path has been tried to get the shortest paths.
    Nothing to be panic much intuition it is simple brute force approach
    int[][] dist =
    [[0, 4, 1e8, 5, 1e8],
     [1e8, 0, 1, 1e8, 6],
     [2, 1e8, 0, 3, 1e8],
     [1e8, 1e8, 1, 0, 2],
     [1, 1e8, 1e8, 4, 0]]
    */
    public void floydWarshall(int[][] dist) {
        // Code here
        int INF = (int)1e8;
        int n = dist.length;
        for(int k=0;k<n;k++){
            for(int i =0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] < INF && dist[k][j] < INF){
                        dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }

                }
            }
        }
    }}

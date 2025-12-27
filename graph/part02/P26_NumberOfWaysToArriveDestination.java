package com.graph.part02;

import com.graph.common.Pair;

import java.util.*;

public class P26_NumberOfWaysToArriveDestination {

    /*
    You are given an undirected weighted graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where edges[i] = [ui, vi, timei] means that there is an undirected edge between nodes ui and vi that takes timei minutes to reach.
    Your task is to return in how many ways you can travel from node 0 to node V - 1 in the shortest amount of time.

    Input: V = 4, edges[][] = [[0, 1, 2], [1, 2, 3], [0, 3, 5], [1, 3, 3], [2, 3, 4]]

    Output: 2
    Explanation:
    The shortest path from 0 to 3 is 5.
    Two ways to reach 3 in 5 minutes are:
    0 -> 3
    0 -> 1 -> 3
    * */

    public int countPaths(int V, int[][] edges) {
        // code here
        List<List<Pair<Integer,Integer>>> adj = new ArrayList<>();

        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i< edges.length;i++){
            adj.get(edges[i][0]).add(new Pair<>(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair<>(edges[i][0],edges[i][2]));
        }

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(
                Comparator
                                .comparingInt((Pair<Integer, Integer> x) -> x.first)
                                .thenComparingInt(x -> x.second)
        );
        int[] dist = new int[V];
        int[]  ways = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[0]=0;
        ways[0]=1;
        queue.offer(new Pair<>(0,0)); // {dist,node}

        while (!queue.isEmpty()){
            Pair<Integer,Integer> curr = queue.poll();
            int distance = curr.first;
            int node = curr.second;

            for(Pair<Integer,Integer> ad: adj.get(node)){
                int nextNode = ad.first;
                int nextWt = ad.second;
                //this is first coming with this short distance
                if( (distance+nextWt) < dist[nextNode]){
                    dist[nextNode] = distance+nextWt;
                    queue.offer(new Pair<>(dist[nextNode],nextNode));
                    ways[nextNode] = ways[node]; //this calculation is important observation
                }else if(distance+nextWt == dist[nextNode]){
                    ways[nextNode] = ways[nextNode]+ways[node];//this calculation is important observation
                }
            }
        }
        return ways[V-1];
    }
}

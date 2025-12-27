package com.graph.part01;

import com.graph.common.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class P14_ShortestPathDirectedAcyclicGraph {

    //from source, we need to find the shortest path to all the node



    public  void shortestPath(int N , int M , int[][] edges){
        //N -> number of node , M-> no of edges

        //Step 01: find the topo sort

        ArrayList<ArrayList<Pair>> adj  = new ArrayList<>();
        for(int i = 0;i<N;i++){
            ArrayList<Pair> p = new ArrayList<>();
            adj.add(p);
        }

        for(int i=0;i<N;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair<>(v, wt));
        }

        boolean[] visited = new boolean[N];
        //store the topo sort element
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<N;i++){
            if(!visited[i]){
                topoSort(i, adj,visited,stack);
            }
        }

        int[] dist = new int[N];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        while(!stack.isEmpty()){
            int node = stack.pop();

            for (int i = 0;i<adj.get(node).size();i++){
                int v = (int) adj.get(node).get(i).first;
                int wt = (int) adj.get(node).get(i).second;

                if(dist[node]+wt < dist[v]){
                    dist[v] = dist[node];
                }
            }
        }

    }

    private void topoSort(int i, ArrayList<ArrayList<Pair>> adj, boolean[] visited, Stack<Integer> stack) {

        visited[i] = true;
        for(Pair ad:adj.get(i)){
            int v = (int) ad.first;
            if(!visited[v]){
                topoSort(v, adj,visited,stack);
            }
        }

        stack.add(i);
    }
}




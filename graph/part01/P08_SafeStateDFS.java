package com.graph.part01;

import java.util.ArrayList;
import java.util.List;

public class P08_SafeStateDFS {

    /*
    Terminal node → out-degree = 0
    Safe node → every path starting from this node eventually ends at a terminal node
    Equivalently:
    A node is unsafe if it is part of a cycle OR leads to a cycle
    */
    private static boolean printSafeState(int src, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited, int[] check) {
        visited[src] = true;
        pathVisited[src] = true;
        check[src] = 0;
        //travers the adjacent node
        for (int ad : adj.get(src)) {
            //when the node is not visited
            if (!visited[ad]) {
                if (printSafeState(ad, adj, visited, pathVisited, check)) {
                    return true;  // from here we will return if it is safe node and all prev is also safe
                }
            }
            //If the node has been previously visited ,but it has to be visited on same path
            else if (pathVisited[ad]) {
                return true;
            }
        }
        check[src] = 1; // check = 1 mean this is safe node
        pathVisited[src] = false;
        return false;
    }


    private static List<Integer> getSafe(int V, List<List<Integer>> adj){
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        int[] color = new int[V];

        for(int i =0;i<V;i++){
            if(!visited[i]){
                printSafeState(i,adj,visited,pathVisited,color);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i =0;i<V;i++){
            if(color[i]==1){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int V =6;
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(4);
        adj.get(1).add(2);
        adj.get(1).add(5);
        adj.get(2).add(1);
        adj.get(3).add(0);
        adj.get(5).add(2);

        List<Integer> result = getSafe(V, adj);
        System.out.println(result);

    }

}

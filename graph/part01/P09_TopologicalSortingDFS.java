package com.graph.part01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P09_TopologicalSortingDFS {


    /*
     * Topological Sort:
     * A linear ordering of vertices such that for every directed edge (u → v),
     * vertex u appears before vertex v in the ordering.
     *
     * Topological sorting is valid only for a DAG
     * (Directed Acyclic Graph — a graph with no cycles).
     */


    private void getTopological(int src, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[src] = true;
        for(int ad :adj.get(src)){
            if(!visited[ad]){
                getTopological(ad,adj,visited,stack);
            }
        }
        stack.add(src);
    }

    private List<Integer> topologicalDFS(int V, List<List<Integer>> adj){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i =0;i<V;i++){
            if(!visited[i]){
                getTopological(i,adj,visited,stack);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }



    /*
    // This implementation is when edges are given in the form of matrix

    public void getTopo(int src , int[][] edges , boolean[] visited,Stack<Integer> stc){


        visited[src]= true;

        // traverse all edges
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            // src → v edge exists
            if (u == src && !visited[v]) {
                getTopo(v, edges, visited, stc);
            }
        }

        stc.add(src);

    }


    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        boolean[] visited = new boolean[V];
        Stack<Integer> stk = new Stack<>();
        for(int i =0;i<V;i++){
            if(!visited[i]){
                getTopo(i,edges,visited,stk);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!stk.isEmpty()){
            ans.add(stk.pop());
        }


        return ans;
    }*/

}

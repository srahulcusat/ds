package com.graph.part01;

import java.util.ArrayList;
import java.util.List;

public class P02_DFS {


    //P02_DFS traversal
    private void getDFS(int src, List<List<Integer>> adj, boolean[] visited, List<Integer> result) {

        visited[src] = true ;
        result.add(src);
        for(int i : adj.get(src)){
            if(!visited[i] ){
                getDFS(i,adj,visited, result);
            }
        }

    }
    public void DFS(int V, List<List<Integer>> adj){
        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<>();

        for(int i =0;i<V;i++){
            if(!visited[i]){
                getDFS(i,adj,visited,result);
            }
        }

    }


}

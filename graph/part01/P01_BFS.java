package com.graph.part01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P01_BFS {


    private void getBFS(int src, List<List<Integer>> adj, boolean[] visited, Queue<Integer> queue) {

        visited[src] = true;
        queue.add(src);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int ele = queue.poll();
            result.add(ele);

            for(int ad : adj.get(ele)){
                if(!visited[ad]){
                    visited[ad] = true;
                    queue.add(ad);
                }
            }
        }
        System.out.println(result);
    }
    //P01_BFS traversal
    public void bfs(int V,List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i<V;i++){
            if(!visited[i]){
                getBFS(i,adj, visited,queue);
            }
        }


    }


}

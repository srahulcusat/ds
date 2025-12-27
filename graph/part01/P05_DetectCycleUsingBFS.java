package com.graph.part01;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P05_DetectCycleUsingBFS {


    //Detect the cycle
    private boolean detechCycleUsingBFS(int src, List<List<Integer>> adj, boolean[] visited) {

        visited[src]=true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, -1});

        while(!queue.isEmpty()){
            int n = queue.peek()[0];
            int parent = queue.peek()[1];
            queue.poll();
            for(int i: adj.get(n)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(new int[]{i,n});
                }
                else if (parent != i){
                    return true ;
                }
            }

        }
        return  false;

    }


    public boolean bfs(int V,List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];
        for(int i =0;i<V;i++){
            if(!visited[i]){
                if(!detechCycleUsingBFS(i,adj, visited)){
                    return false ;
                }
            }
        }
        return true;
    }


}

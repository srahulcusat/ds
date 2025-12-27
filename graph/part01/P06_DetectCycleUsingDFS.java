package com.graph.part01;


import java.util.List;

public class P06_DetectCycleUsingDFS {


    //Detect the cycle using P02_DFS
    private boolean detectCycleUsingDFS(int src,int parent, List<List<Integer>> adj, boolean[] visited) {

        visited[src]=true;
        for(int ad : adj.get(src)){
            if(!visited[ad]){
                if(detectCycleUsingDFS(ad,src, adj,visited) ){
                    return true ;
                }
            }else if (ad !=parent) {
                return true;
            }
        }
        return  false;
    }


    public boolean dfs(int V,List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];

        for(int i =0;i<V;i++){
            if(!visited[i]){
                if(detectCycleUsingDFS(i,-1,adj, visited)){
                    return true ;
                }
            }
        }
        return true;
    }


}

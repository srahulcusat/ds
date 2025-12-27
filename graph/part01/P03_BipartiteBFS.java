package com.graph.part01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P03_BipartiteBFS {

    //Graph is bipartite if able to color the graph using 2 color , and adjacent node is not of same color

   private boolean checkForBipartiteBFS(int src , List<List<Integer>> adj ,int[] color){

       Queue<Integer> queue = new LinkedList<>(); // it will have <node,parent>
       queue.add(src);
       color[src] = 0;

       while(!queue.isEmpty()){
           int node = queue.poll();

           for(int ad: adj.get(node)){
               if(color[ad] == -1){
                   color[ad] = 1-color[node];
                   queue.add(ad);
               }else if(color[ad]==color[node]){
                   return  false;
               }
           }

       }
       return true;
   }

   private boolean bipartite(int V, List<List<Integer>> adj){
       int[] color = new int[V];
       Arrays.fill(color, -1);

       for(int j  = 0;j<V;j++){
           if(color[j] ==-1){
               if(checkForBipartiteBFS(j,adj,color)){
                   return true;
               }
           }

       }
       return false;

   }
}


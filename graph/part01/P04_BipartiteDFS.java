package com.graph.part01;

import java.util.Arrays;
import java.util.List;

public class P04_BipartiteDFS {

    //Graph is bipartite if able to color the graph using 2 color , and adjacent node is not of same color

    private boolean checkForBipartiteDFS(int src,int col, List<List<Integer>> adj, int[] color) {

        color[src] = col;

        for (int ad : adj.get(src)) {
          if(color[ad] == -1){
              if(!checkForBipartiteDFS(ad,1-col,adj,color)){
                  return false;
              }
          }else if(color[src] == color[ad]){
              return false;
          }

        }
        return true;
    }

    private boolean bipartite(int V, List<List<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int j = 0; j < V; j++) {
            if (color[j] == -1) {
                if (!checkForBipartiteDFS(j, 0, adj, color)) {
                    return false;
                }
            }
        }
        return true;

    }
}


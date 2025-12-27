package com.graph.part01;

import java.util.*;

public class P11_TopologicalSortingBFS_KanhnAlgo {

    /*
        Kahn’s Algorithm — Definition:
        Kahn’s Algorithm is a BFS-based method to find the Topological Order of a Directed Acyclic Graph (DAG).
        It works by repeatedly removing vertices with in-degree = 0 (no incoming edges)
        and processing their outgoing edges.

        If after processing all possible nodes, some nodes still remain (i.e., cycle exists),
        then topological ordering is not possible
    */

    public ArrayList<Integer> getTopo(int V , List<List<Integer>> adj){
        //First store the in Degree of each node
        int[] in_degree = new int[V];
        Arrays.fill(in_degree,0);
        for(int i =0;i<V;i++){
            for(int ad : adj.get(i)){
                in_degree[ad]++;
            }
        }

        Queue<Integer> queue   = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        //Push each node having in degree as 0 to queue
        //Reason , no node can be before this , hence it can be kept at beginning
        for(int i =0;i<V;i++){
            if(in_degree[i] == 0){
                queue.offer(i);
            }
        }

        //Iterate the queue until its empty , if any node degree become zero it mean all the node before it is already added to queue
        while (!queue.isEmpty()){
            int currNode = queue.poll();
            result.add(currNode);
            for(int ad:adj.get(currNode)){
                in_degree[ad]--;
                if(in_degree[ad] == 0){
                    queue.offer(ad);
                }

            }
        }
        return result;
    }
}

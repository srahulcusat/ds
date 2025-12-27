package com.graph.part02;

import java.util.*;

public class P20_DijkstraPrintPath {


    class Solution {
        public List<Integer> shortestPath(int n, int m, int edges[][]) {
            //  Code Here.

            List<List<List<Integer>>> adj = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            // edges[i] = {u, v, w}
            for (int i = 0; i < m; i++) {

                int u = edges[i][0];
                int v = edges[i][1];
                int w = edges[i][2];

                // u -> v
                List<Integer> e1 = new ArrayList<>();
                e1.add(v);
                e1.add(w);
                adj.get(u).add(e1);

                // v -> u (UNDIRECTED)
                List<Integer> e2 = new ArrayList<>();
                e2.add(u);
                e2.add(w);
                adj.get(v).add(e2);
            }


            //Store the parent , from where current path is coming from
            int[] parent = new int[n + 1];
            int[] minDist = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                minDist[i] = Integer.MAX_VALUE;
            }

            PriorityQueue<CustomPair> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));


            queue.offer(new CustomPair(0, 1));

            minDist[1] = 0;

            while (!queue.isEmpty()) {

                CustomPair q = queue.poll();
                int distance = q.distance;
                int node = q.node;

                for (int i = 0; i < adj.get(node).size(); i++) {
                    int adjNode = adj.get(node).get(i).get(0);
                    int adjWt = adj.get(node).get(i).get(1);

                    if(distance+adjWt<minDist[adjNode]){
                        minDist[adjNode] = distance+adjWt;
                        parent[adjNode]=node;
                        queue.offer(new CustomPair(minDist[adjNode],adjNode));
                    }
                }
            }

            List<Integer> path = new ArrayList<>();
            if(minDist[n] == Integer.MAX_VALUE){
                path.add(-1);
                return  path;
            }

            //0,1,1,4,1,3,4
            int node = n;
            //5,3,4
            //node = 1
            while (parent[node] !=node){
                path.add(node);
                node = parent[node];
            }


            path.add(1);

            Collections.reverse(path);

            /*
             * [[ totalWeight, node1, node2, ..., nodeN ]]
             *
             * */
            path.add(0, minDist[n]);


            return path;
        }
    }

}

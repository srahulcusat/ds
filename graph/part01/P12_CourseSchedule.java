package com.graph.part01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P12_CourseSchedule {

    /*
    * You are given n courses, labeled from 0 to n - 1
    * and a 2d array prerequisites[][] where prerequisites[i] = [x, y]
    * indicates that we need to take course  y first if we want to take course x.
    * Find the ordering of courses we should take to complete all the courses.
    * prerequisites[i] = [a, b]
    * to take course a, you must first take course b edge: b → a
    * */

    public boolean isPossible(int n, int[][] prerequisites) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }


        int[] inDegree = new int[n];

        for(int i =0;i<n;i++){
            for(int ad: adj.get(i)){
                inDegree[ad]++;
            }
        }


        Queue<Integer> queue  = new LinkedList<>();

        for(int i =0;i<n;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            for(int ad: adj.get(node)){
                inDegree[ad]--;
                if(inDegree[ad] == 0){
                    queue.offer(ad);
                }
            }
        }
        System.out.println(result);
        if (result.size() != n) {
            return false;
        }

        return true;
    }
}
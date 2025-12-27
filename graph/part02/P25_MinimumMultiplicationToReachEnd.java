package com.graph.part02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P25_MinimumMultiplicationToReachEnd {

    /*
        Given start, end and an array arr of n numbers.
        At each step, start is multiplied with any number in the array and then mod operation with 100000 is done to get the new start.
        Your task is to find the minimum steps in which end can be achieved starting from start.
        If it is not possible to reach end, then return -1.
    */
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int MOD = 100000;

        int[] dist= new int[MOD]; //this will to reach the index number what is the no of  step taken
        Arrays.fill(dist,Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;
        //[0,]
        while (!queue.isEmpty()){
            int curr = queue.poll();

            if(curr == end){
                return dist[curr];
            }
            for(int i =0;i< arr.length;i++){
                int next = (curr*arr[i])%MOD;
                if(1+ dist[curr] < dist[next]) {
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }
        return -1;
    }
}

package com.graph.part02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P23_PathWithMinimumEffort {


    /*

    You are given a 2D array mat[][], of size n*m.
    Your task is to find the minimum possible path cost from the top-left cell (0, 0) to the bottom-right cell (n-1, m-1) by moving up, down, left, or right between adjacent cells.

    Note: The cost of a path is defined as the maximum absolute difference between the values of any two consecutive cells along that path.
    Input: mat[][] = [[2, 2, 2, 1],
               [8, 1, 2, 7],
               [2, 2, 2, 8],
               [2, 1, 4, 7],
               [2, 2, 2, 2]]
    Output: 0
    Explanation: The route of [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2] has a minimum value of maximum
    absolute difference between any two consecutive cells in the route, i.e., 0.

    */

    public int minCostPath(int[][] mat) {
        // code here
        int row = mat.length;
        int col = mat[0].length;
        int[][] dist = new int[row][col];
        for (int[] ints : dist) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        dist[0][0]=0;
        PriorityQueue<PairNew> queue = new PriorityQueue<>(Comparator.comparingInt(x->x.distance));
        queue.offer(new PairNew(0, new int[]{0,0}));

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while (!queue.isEmpty()){
            PairNew ele =  queue.poll();
            int diff= ele.distance;
            int[] cell = ele.cell;
            if(row == cell[0] && col == cell[1]) return diff;

            for(int i =0;i<4;i++){
                int newRow = cell[0]+dr[i];
                int newCol = cell[1]+dc[i];

                if(newRow>=0 && newRow<row && newCol>=0 && newCol<col ){
                    int newEffort =  Math.max(diff , Math.abs( mat[cell[0]][cell[1]] - mat[newRow][newCol]));
                    if(newEffort<dist[newRow][newCol]){
                        dist[newRow][newCol] = newEffort;
                        queue.offer(new PairNew(newEffort,new int[]{newRow,newCol}));
                    }
                }
            }

        }

        return 0;
    }
}


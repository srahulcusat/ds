package com.graph.part02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P22_BinaryMazeShortestPath {
    /*
    Given a n * m matrix grid where each element can either be 0 or 1.
    You need to find the shortest distance between a given source cell to a destination cell.
    The path can only be created out of a cell if its value is 1.
    If the path is not possible between source cell and destination cell, then return -1.

    Note : You can move into an adjacent cell if that adjacent cell is filled with element 1.
    Two cells are adjacent if they share a side.
    In other words, you can move in one of the four directions, Up, Down, Left and Right.
    The source and destination cell are based on the zero based indexing. The destination cell should be 1.

    Example 1:

    Input:
    grid[][] = {{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}}
    source = {0, 1}
    destination = {2, 2}
    Output:
    3
    */

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }
        // Your code here
        int[][] dist = new int[grid.length][grid[0].length];

        for (int[] ints : dist) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        //In the queue {dist,{row,col}}
        Queue<PairNew> queue = new LinkedList<>();

        queue.offer(new PairNew(0, source));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int ans = -1;
        dist[source[0]][source[1]] = 0;
        while (!queue.isEmpty()) {
            PairNew ele = queue.poll();
            int distance = ele.distance;
            int[] cell = ele.cell;

            for (int i = 0; i < 4; i++) {
                int newRow = cell[0] + dr[i];
                int newCol = cell[1] + dc[i];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] != 0 && distance + 1 < dist[newRow][newCol]) {

                    dist[newRow][newCol] = distance + 1;
                    if (newRow == destination[0] && newCol == destination[1]) {
                        return distance + 1;
                    }
                    queue.offer(new PairNew(distance + 1, new int[]{newRow, newCol}));
                }
            }
        }

        return ans;
    }


}

class PairNew {
    Integer distance;
    int[] cell;

    PairNew(Integer distance, int[] cell) {
        this.distance = distance;
        this.cell = cell;
    }
}
package com.leetcode.leetcode_daily;

import java.util.Arrays;

public class Problem03 {

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        int row = grid.length;
        boolean[] mem = new boolean[row*row+1];

        Arrays.fill(mem ,false);
        int a=0 , b=0 ;

        for (int[] ints : grid) {
            for (int j = 0; j < row; j++) {
                if (mem[ints[j]]) {
                    a = ints[j];

                } else {
                    mem[ints[j]] = true;
                }
            }
        }


        for(int i =1;i<row*row+1;i++){
            if(!mem[i]){
                b = i;
                break;
            }
        }
        result[0] = a;
        result[1] = b;
        return result;
    }
    public static void main(String[] args) {
        /*
        You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2].
        Each integer appears exactly once except a which appears twice and b which is missing.
        The task is to find the repeating and missing numbers a and b.
        Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b
        */
        int[][] arr = {{9,1,7},{8,9,2},{3,4,6}};
        int[] result = findMissingAndRepeatedValues(arr);

        System.out.println("{"+result[0]+","+result[1]+"}");
    }
}

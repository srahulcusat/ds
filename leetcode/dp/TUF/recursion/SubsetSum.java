package com.leetcode.dp.TUF.recursion;

import java.util.PriorityQueue;
import java.util.Queue;

public class SubsetSum {
    public static int count=0;
    public static void subSetSum(int[]arr ,int i, int sum,Queue<Integer> queue){
        count++;
        if(i== arr.length){
            queue.add(sum);
            return;
        }
        subSetSum(arr,i+1,sum+arr[i],queue);
        subSetSum(arr,i+1,sum,queue);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        int[] arr ={1,2,3};
        subSetSum(arr,0,0,queue);
        System.out.println(queue);
    }
}

package com.leetcode.dp.TUF.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void findSum(int[] arr, int target, int index, List<List<Integer>>  result, List<Integer> dp ){

        if(target ==0){
            result.add(new ArrayList<>(dp));
            return;
        }

        for(int i =index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1])
                continue;
            if(target<arr[i])
                break;
            dp.add(arr[i]);
            findSum(arr,target-arr[i],i+1,result,dp);
            dp.remove(dp.size()-1);

        }


    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result  = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates,target,0,result, new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {

        /*
        Given a collection of candidate numbers (candidates) and a target number (target),
        find all unique combinations in candidates where the candidate numbers sum to target.
        Each number in candidates may only be used once in the combination.
        Note: The solution set must not contain duplicate combinations.
        */
        int[] arr = {10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>> result = combinationSum2(arr, target);

        System.out.println(result);
    }
}

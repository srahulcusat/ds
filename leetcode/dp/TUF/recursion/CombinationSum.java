package com.leetcode.dp.TUF.recursion;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        /*
        any index can be pick infinite number of time
        */

        int[] arr = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = new ArrayList<>();
        getTargetSumPair(arr, 0, target, result, new ArrayList<>());
        System.out.println(result);
    }

    private static void getTargetSumPair(int[] arr, int i, int target, List<List<Integer>> result, List<Integer> dp) {

        if (i == arr.length - 1) {
            if (target == 0)
                result.add(new ArrayList<>(dp));
            return;
        }
        //pick up the element
        if(arr[i]<=target){
            dp.add(arr[i]);
            getTargetSumPair(arr, i, target - arr[i], result, dp);
            dp.remove(dp.size() - 1);
        }
        //don't pick the element
        getTargetSumPair(arr, i + 1, target, result, dp);
    }
}

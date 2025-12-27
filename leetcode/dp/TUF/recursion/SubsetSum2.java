package com.leetcode.dp.TUF.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum2 {




    public static void main(String[] args) {
         /*
            Generate the unique subset
            int[] arr = {1,2,2,2,3,3};

            subset :
                Size 0 -> {}
                Size 1 -> {1}{2}{3]
                Size 2 ->{1,2}{1,3}{2,2}{2,3}{3,3}
        */
        int[] nums = {1,2,2,2,3,3};
        Arrays.sort(nums);
        List<List<Integer>> ans =new ArrayList<>();

        findSubset(0,nums ,new ArrayList<Integer>(),ans);
        System.out.println(ans);
    }

    private static void findSubset(int ind, int[] nums, ArrayList<Integer> dp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(dp));
        for (int i =ind ;i<nums.length;i++){
            if(i!=ind && nums[i] == nums[i-1])
                    continue;
            dp.add(nums[i]);
            findSubset(i+1,nums,dp,ans);
            dp.remove(dp.size()-1);
        }
    }
}


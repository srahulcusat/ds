package com.leetcode.leetcode75.array;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        if( nums== null || nums.length < 3)
            return new ArrayList<>();

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for(int i =0;i<nums.length;i++){
            int start= i+1;
            int end = nums.length-1;

            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum==0){
                    result.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    start++;
                    end--;
                }else if(sum < 0){
                    start++;
                }else{
                    end--;
                }
            }
        }

        return new ArrayList<>(result);

    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        //-4,-1,-1,0,1,2
        List<List<Integer>> result =  threeSum(nums);

        System.out.println(result);
    }
}

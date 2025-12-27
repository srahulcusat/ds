package com.leetcode.leetcode75.array;

import java.util.*;

public class TwoSum {


    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> m = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {

            int tempSum = target - nums[i];
            if (m.containsKey(tempSum)) {
                int k = m.get(tempSum);
                result[0] = k;
                result[1] = i;
            } else {
                m.put(nums[i], i);
            }

        }
        return result;
    }

    public static int[] getTwoSum(int[] nums, int start,int end, int target){
        int[] result  = new int[2];

        while(start<end){
            int sum = nums[start] + nums[end];
            if(sum == target){
                result[0] = nums[start];
                result[1] = nums[end];
                break;
            }
            else if(sum<target)
                start++;
            else
                end--;
        }
        return nums;
    }

    public static void main(String[] args) {
        //We have sorted the arrays
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = getTwoSum(nums,0,3,target);

        System.out.println("Indices for array sum to target is:"+result[0]+","+result[1]);
    }
}

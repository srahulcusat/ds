package com.leetcode.leetcode75.array;

public class MaxSubArray {

    public static int maxSubArray(int[] nums) {

        int n = nums.length;
        int res = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < n; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            res = Math.max(currentMax, res);
        }
        return res;
    }

    public static void main(String[] args) {
        /*
        Given an integer array nums, find the subarray
        with the largest sum, and return its sum.
        */
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(nums);
        System.out.println(result);

    }
}

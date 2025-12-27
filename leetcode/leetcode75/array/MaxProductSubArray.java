package com.leetcode.leetcode75.array;

public class MaxProductSubArray {
    public static int maxProduct(int[] nums) {
        /*
        We have to move from both end as number of negative can be either even or odd
        and also there can be zero in the array
        */
       int prev = 1, suff = 1 ;
       int ans = Integer.MIN_VALUE;
       int n = nums.length;

       for (int i =0;i<n;i++){
           if(prev ==0)
               prev =1;
           if(suff ==0)
               suff =1;
           prev = prev * nums[i];
           suff = suff * nums[n-i-1];
           ans = Math.max(ans,Math.max(prev,suff));
       }

       return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, -3, -2, 4};
        int result = maxProduct(nums);
        System.out.println(result);
    }
}

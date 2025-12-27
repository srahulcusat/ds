package com.leetcode.leetcode_daily;

import java.util.Arrays;

public class Problem01 {

    public static int[] applyOperations(int[] nums) {
        int len = nums.length;
        int j = len-1;

        for(int i =0;i<len-1;i++){

            if(nums[i] == nums[i+1]){
                int temp = nums[i+1];
                nums[i]=2*nums[i+1];
                nums[i+1]=0;
            }
            if(nums[i+1] == 0){
                //swamp j with i+1;
                int temp = nums[j];
                nums[j] = 0;
                nums[i+1]=temp;
                j--;
            }
        }
        if(nums[len-1] != 0){
            int temp = nums[len-1];
            nums[len-1] = temp;
            nums[j]=temp;
        }
        return nums;
    }

    public  static  int[] moveZeroToEnd(int[] nums){
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2,0,0,1};
        int[] result = moveZeroToEnd(nums);
        System.out.println(Arrays.toString(result));
    }
}

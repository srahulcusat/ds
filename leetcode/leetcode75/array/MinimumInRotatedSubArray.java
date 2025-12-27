package com.leetcode.leetcode75.array;

public class MinimumInRotatedSubArray {

    public static int findMin(int[] nums) {

        if (nums.length <= 1)
            return nums[0];
        int result = Integer.MIN_VALUE;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] > nums[right]) {
                    result = nums[right];
                left++;
            } else {
                result = nums[left];
                right--;
            }
        }

        return result;

    }

    public static void main(String[] args) {

/*
    Given the sorted rotated array nums of unique elements,
    return the minimum element of this array.
*/
        int[] nums = {3, 4, 5, 1, 2};
        int result = findMin(nums);
        System.out.println(result);
    }
}

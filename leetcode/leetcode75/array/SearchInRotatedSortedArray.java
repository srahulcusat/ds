package com.leetcode.leetcode75.array;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        if(nums.length ==1){
            if(target == nums[0])
                return 0;
            return -1;
        }

        int result = Integer.MIN_VALUE;
        int start = 0 , end = nums.length-1;

        while(start<end){
            int s = nums[start];
            int e = nums[end];
            if(target == s)
                return start;
            else if(target == e)
                return end;
            else if(target<s && target <e){
                start++;
                end--;
            }
            else if (target<e)
                end --;
            else if(target > s)
                start++;
            else {
                start++;
                end--;
            }
        }

        if(target == nums[start])
            return start;
        return -1;
    }
    public static void main(String[] args) {
        /*
        Given the array nums after the possible rotation and an integer target,
        return the index of target if it is in nums, or -1 if it is not in nums.
        You must write an algorithm with O(log n) runtime complexity.
        */




        int[] nums = {4,5,6,7,0,1,2};
       int result = search(nums, 0);
       System.out.println(result);
    }
}

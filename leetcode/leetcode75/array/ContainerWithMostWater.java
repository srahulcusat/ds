package com.leetcode.leetcode75.array;

public class ContainerWithMostWater {


    public static int maxAreaOptimal(int[] height) {



        int result = Integer.MIN_VALUE;
        int left = 0 ;
        int right = height.length-1;

        while(left<right){
            int w = right-left;
            int h = Math.min(height[left],height[right]);
            result = Math.max(result,h*w);
            if(height[left] < height[right])
                    left++;
            else
                right--;
        }
        return result;
    }
    public static int maxArea(int[] height) {

        // Area = height * width ;

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int w = j - i;
                result = Math.max(result, h * w);
            }
        }
        return result;
    }

    public static void main(String[] args) {

       /*
       You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
       Find two lines that together with the x-axis form a container, such that the container contains the most water.
       Return the maximum amount of water a container can store.
       Notice that you may not slant the container.
        */

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxAreaOptimal(height);
        System.out.println(result);
    }
}

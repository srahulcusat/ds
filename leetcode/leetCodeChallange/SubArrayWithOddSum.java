package com.leetcode.leetCodeChallange;

public class SubArrayWithOddSum {

    public static int numOfSubarrays(int[] arr) {
        int mod = 1000000007;

        int evenC =1;
        int oddC =0;
        int prefixSum =0;
        int count=0;


        for(int a :arr ){
            prefixSum+=a;
            if(prefixSum%2 ==0){
                count+=oddC;
                evenC++;
            }else{
                count+=evenC;
                oddC++;
            }
            count= count%mod;
        }
        return count;
    }
    public static void main(String[] args) {

        /*
        Given an array of integers arr, return the number of subarrays with an odd sum.
        Since the answer can be very large, return it modulo 109 + 7.
        Example 1:
        Input: arr = [1,3,5]
        Output: 4
        Explanation: All subArrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
        All sub-arrays sum are [1,4,9,3,8,5].
        Odd sums are [1,9,3,5] so the answer is 4.


        Note: SubArrays is consecutive number pair eg, shown above
         */

        int[] arr = {1,3,5};

        /*
          Explanation Link: https://www.youtube.com/watch?v=XB-z2cHXVzY
        */

        int result = numOfSubarrays(arr);

        System.out.println(result);

    }
}

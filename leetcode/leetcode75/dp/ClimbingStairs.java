package com.leetcode.leetcode75.dp;

public class ClimbingStairs {

    public  static  int climbStairsMethod2(int n){
        if(n<=3)
            return n;
        int prev1 = 1;
        int prev2 = 2;
        int curr = 0;
        for(int i =3;i<=n;i++)
        {
            curr = prev1+prev2;
            prev1= prev2;
            prev2 = curr;
        }
        return curr;
    }
    public static void main(String[] args) {
        int n =6;
        int result = climbStairsMethod2(n);
        System.out.println(result);
    }
}

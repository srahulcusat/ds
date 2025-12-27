package com.leetcode.dp;

public class KnapsnackPrb {


    public static void main(String[] args) {

//        0/1 Knapsnack problem
        int[] w ={1,3,4,6};
        int[] v ={20,30,10,50};
        int n =w.length;
        int c =8;
        int[][]dp = new int[n+1][c+1];

        for(int i =0 ; i <c; i++){
            dp[0][i] = 0;
        }
        for(int i =0 ; i <n; i++){
            dp[i][0] = 0;
        }
        for(int i =1;i<=n;i++){
            for(int j =1;j<=c ;j++){
                int prevSub = dp[i-1][j];
                int currP = v[i-1];
                int currW = w[i-1];
                if(currW <= j){
                    dp[i][j] = Math.max(prevSub,currP+dp[i-1][j-currW]);
                }else{
                    dp[i][j]=prevSub;
                }

            }
        }
        System.out.println(dp[n][c]);
    }
}

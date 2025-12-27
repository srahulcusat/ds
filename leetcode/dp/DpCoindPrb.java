package com.leetcode.dp;

public class DpCoindPrb {

    public static void main(String[] args) {
       /* int[] coins = {1, 2, 5};
        int n = 10;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int result = minCoin(coins, n, dp);
        System.out.println(result);
*/
        /*

        0   1 2 3 4 5 6 7 8 9 10 11
        1   1 2 3 4 5 7 7 8 9 10 11
        2   1 1 2 2
        3   1 1
        */
    }

    public static int minCoin(int[] coins, int amount, int[] dp) {
        if(amount==0)
            return 0;
        int ans = Integer.MAX_VALUE;

        for(int i =0;i<coins.length;i++){

            if((amount-coins[i])>=0){
                int currAns=0;
                if(dp[amount-coins[i]]!=-1){
                    currAns= dp[amount-coins[i]];
                }else{
                    currAns =  minCoin(coins,amount-coins[i],dp);
                }

                ans = Math.min(currAns+1,ans);
            }
        }

        dp[amount] = ans ;
        return ans ;
    }


}

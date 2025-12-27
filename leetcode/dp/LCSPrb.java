package com.leetcode.dp;

public class LCSPrb {

    public static void main(String[] args) {
        String s1 = "ABCAB";
        String s2 = "AECB";
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        /*
        //LCS using memoization i.e. topdown approach - recursive approch
        lcsMemo(n,m,s1,s2,dp);
        */

        //LCS using tabulation Method i.e. bottom-up approach for iterative approach
        lcsUtilsU(n, m, s1, s2, dp);
    }

    private static void lcsUtilsU(int n, int m, String s1, String s2, int[][] dp) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) ) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println("result:" + dp[n][m]);
    }

    private static void lcsMemo(int n, int m, String s1, String s2, int dp[][]) {


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        int result = lcsUtils(n, m, s1, s2, dp);
        System.out.println("result:" + result);
    }

    private static int lcsUtils(int n, int m, String s1, String s2, int[][] dp) {
        if (n == 0 || m == 0)
            return 0;

        if (dp[n][m] != -1)
            return dp[n][m];
        int ans = 0;
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            ans = 1 + lcsUtils(n - 1, m - 1, s1, s2, dp);
        } else {
            ans = Math.max(lcsUtils(n, m - 1, s1, s2, dp), lcsUtils(n - 1, m, s1, s2, dp));
        }
        dp[n][m] = ans;
        return dp[n][m];
    }
}

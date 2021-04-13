package com.elmer.leetcode.t801_;

public class Solution935 {
    public int knightDialer(int n) {
        // dp[i][j] = \sum_{k=0}^{9} dp[i-1][k]
        int mod = 1000000000 + 7;
        int[][] dp = new int[n][10];
        for (int k = 0; k < 10; k++) {
            dp[0][k] = 1;
        }

        int[][] moves = new int[][]{
                {4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}
        };

        for (int i = 1; i < n; i++) {
            for (int k = 0; k < 10; k++) {
                int[] mo = moves[k];
                for (int m : mo) {
                    dp[i][k] = (dp[i][k] + dp[i-1][m]) % mod;
                }
            }
        }

        int res = 0;
        for (int k = 0; k < 10; k++) {
            res = (res + dp[n-1][k]) % mod;
        }
        return res;
    }
}

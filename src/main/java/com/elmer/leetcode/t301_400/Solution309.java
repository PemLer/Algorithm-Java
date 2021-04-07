package com.elmer.leetcode.t301_400;

public class Solution309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            if (i > 1) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
        }
        return dp[n-1][0];
    }
}

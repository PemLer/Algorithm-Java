package com.elmer.leetcode.offer;

public class Solution60 {
    public double[] dicesProbability(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <=  6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k >= i - 1) dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        double base = Math.pow(6, n);
        double[] res = new double[6 * n - n + 1];
        for (int i = n; i <= 6*n; i++) {
            res[i - n] = dp[n][i] / base;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution60 sol = new Solution60();
        sol.dicesProbability(1);
    }
}

package com.elmer.leetcode.t101_200;

import java.util.Arrays;

public class Solution174 {
    public int calculateMinimumHP(int[][] dungeon) {
        // dp[i][j] = min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
        // 在 dungeon[i][j] 需要多少生命
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n-1] = dp[m-1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int min = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(min - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}

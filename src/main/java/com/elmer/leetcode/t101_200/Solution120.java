package com.elmer.leetcode.t101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // dp[i][j] = min(dp[i-1][j], dp[i-1][j-1]) + c[i][j]
        int n = triangle.size();
        if (n == 0) {
            return -1;
        }
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int min = dp[n-1][0];
        for (int k = 1; k < n; k++) {
            min = Math.min(min, dp[n-1][k]);
        }
        return min;
    }
}

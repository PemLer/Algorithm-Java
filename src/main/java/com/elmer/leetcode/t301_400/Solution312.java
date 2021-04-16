package com.elmer.leetcode.t301_400;

import java.util.Arrays;

public class Solution312 {

    public int maxCoins(int[] nums) {
        // dp[i][j] 表示(i, j)内的位置全部填满气球能够得到的最多硬币数
        // dp[i][j] = max_{mid} val[i] * val[mid] * val[j] + dp[i][mid] + dp[mid][j]
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i+1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], newNums[i] * newNums[k] * newNums[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n+1];
    }
}

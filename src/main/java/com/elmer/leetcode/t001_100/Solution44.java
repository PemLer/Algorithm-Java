package com.elmer.leetcode.t001_100;

public class Solution44 {
    public boolean isMatch(String s, String p) {
        // p[j] == ?  dp[i][j] = dp[i-1][j-1]
        // p[j] == *  dp[i][j] = dp[i][j-1] or dp[i-1][j]
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        // 初始状态
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}

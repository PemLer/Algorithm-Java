package com.elmer.leetcode.t101_200;

public class Solution115 {
    public int numDistinct(String s, String t) {
        // s的子序列中t出现的个数
        // j = 0
        // dp[i][j]  s[:i]的子序列中t[:j]出现的次数
        // dp[i][j] = 1
        // s[i] == t[j]
        //   dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
        // s[i] != t[j]
        //   dp[i][j] = dp[i][j-1]
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= Math.min(i, n); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution115 sol = new Solution115();
        sol.numDistinct("babgbag", "bag");
    }
}

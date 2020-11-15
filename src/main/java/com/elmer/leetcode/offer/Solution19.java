package com.elmer.leetcode.offer;

public class Solution19 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // B为空时，只有A也为空时才为true
                if (j == 0) {
                    dp[i][j] = i == 0;
                } else {
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
                        // 0次
                        if (j >= 2) {
                            dp[i][j] = dp[i][j - 2];
                        }
                        // 多次
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            dp[i][j] |= dp[i - 1][j];  // 取或，因为可能前面0次为真，而多次为假
                        }
                    }
                }
            }
        }
        return dp[n][m];
    }
}

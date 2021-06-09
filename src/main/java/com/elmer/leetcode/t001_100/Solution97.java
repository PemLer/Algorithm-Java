package com.elmer.leetcode.t001_100;

public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), k = s3.length();
        if (m + n != k) {
            return false;
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    dp[j] = dp[j] || dp[j-1] && s2.charAt(j - 1) == s3.charAt(p);
                }
            }
        }
        return dp[n];
    }
}

package com.elmer.leetcode.t001_100;

public class Solution5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1, startId = 0;
        for (int len = 0; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                if (len == 0) {
                    dp[i][j] = true;
                } else if (len == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (dp[i+1][j-1] && s.charAt(i) == s.charAt(j));
                }
                if (dp[i][j] && len + 1 > maxLen) {
                    maxLen = len + 1;
                    startId = i;
                }
            }
        }
        return s.substring(startId, startId + maxLen);
    }

    public static void main(String[] args) {
        String s = "ababababababa";
        Solution5 sol = new Solution5();
        sol.longestPalindrome(s);
    }
}

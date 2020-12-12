package com.elmer.leetcode.t001_100;

public class Solution91 {
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i-1) != '0') {
                if (i > 1 && checkValid(s.charAt(i-2), s.charAt(i-1))) {
                    dp[i] = dp[i-1] + dp[i-2];
                } else {
                    dp[i] = dp[i-1];
                }
            } else {
                if (s.charAt(i-2) > '2' || s.charAt(i-2) == '0') return 0;
                dp[i] = dp[i-2];
            }
        }
        return dp[n];
    }

    private boolean checkValid(char a, char b) {
        if (a == '0') return false;
        int val = (a - '0') * 10 + (b - '0');
        return val <= 26;
    }
}

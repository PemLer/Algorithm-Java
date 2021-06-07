package com.elmer.leetcode.t001_100;

public class Solution38 {
    public String countAndSay(int n) {
        String[] dp = new String[n];
        dp[0] = "1";
        for (int i = 1; i < n; i++) {
            dp[i] = describe(dp[i-1]);
        }
        return dp[n-1];
    }

    private String describe(String s) {
        int count = 0, i = 0, n = s.length();
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            char c = s.charAt(i++);
            count++;
            while (i < n && s.charAt(i) == c) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(c);
            if (i == n) {
                break;
            }
            count = 0;
        }
        return sb.toString();
    }
}

package com.elmer.leetcode.t101_200;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (set.contains(s.substring(i, j + 1))) {
                    dp[j+1] |= dp[i];
                }
            }
        }
        return dp[n];
    }
}

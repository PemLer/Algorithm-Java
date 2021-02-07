package com.elmer.leetcode.contest.Dweekly_contest_45;

import java.util.Arrays;

public class Solution5660 {

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (x, y) -> x[1] - y[1]);
        int n = events.length;
        int[] endTimes = new int[n];
        for (int i = 0; i < n; i++) {
            endTimes[i] = events[i][1];
        }
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int startTime = events[i-1][0], value = events[i-1][2];
                int le = 0, ri = n - 1, mid;
                while (le < ri) {
                    mid = (le + ri) / 2;
                    if (endTimes[mid] < startTime) {
                        le = mid + 1;
                    } else {
                        ri = mid;
                    }
                }
                dp[i][j] = Math.max(dp[le][j - 1] + value, dp[i - 1][j]);
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        Solution5660 sol = new Solution5660();
        int[][] events = {{1,1,1},{2,2,2},{3,3,3},{4,4,4}};
        int k = 3;
        System.out.println(sol.maxValue(events, k));
    }

}

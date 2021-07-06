package com.elmer.leetcode.t301_400;

import java.util.Arrays;

public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        // 对宽度升序，高度降序。因此题目变成了寻找高度的最长严格递增序列的长度
        Arrays.sort(envelopes, (x, y) -> (x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]));
        int n = envelopes.length;
        int[] dp = new int[n];
        dp[0] = envelopes[0][1];
        int index = 0;
        for (int i = 1; i < n; i++) {
            int h = envelopes[i][1];
            if (h > dp[index]) {
                dp[++index] = h;
            } else {
                int left = 0, right = index;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (dp[mid] < h) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                dp[left] = h;
            }
        }
        return index + 1;
    }
}

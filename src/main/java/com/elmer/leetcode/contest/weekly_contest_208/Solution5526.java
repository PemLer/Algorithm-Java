package com.elmer.leetcode.contest.weekly_contest_208;

public class Solution5526 {
    // 状态压缩 枚举
    public int maximumRequests(int n, int[][] requests) {
        int length = requests.length;
        int m = 1 << length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int[] degree = new int[n];
            int tmp = 0;
            for (int j = 0; j < length; j++) {
                if (((i >> j) & 1) == 1) {
                    tmp++;
                    degree[requests[j][0]] -= 1;
                    degree[requests[j][1]] += 1;
                }
            }

            boolean flag = true;
            for (int d: degree) {
                if (d != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) res = Math.max(res, tmp);
        }
        return res;
    }
}

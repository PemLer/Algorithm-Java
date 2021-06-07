package com.elmer.leetcode.t001_100;

public class Solution45 {
    public int jump(int[] nums) {
        // [2,3,1,1,4]
        // [2,3,0,1,4]
        // [1, 2]
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        int cur = 0, pos = 0, count = 0;
        for (int i = 0; i < n; i++) {
            pos = Math.max(pos, i + nums[i]);
            if (i == cur) {
                cur = pos;
                count++;
                if (cur >= n - 1) {
                    break;
                }
            }
        }
        return count;
    }
}

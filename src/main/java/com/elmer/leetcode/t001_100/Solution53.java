package com.elmer.leetcode.t001_100;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int total = nums[0], res = nums[0];
        for (int i = 1; i < n; i++) {
            if (total < 0) {
                total = nums[i];
            } else {
                total += nums[i];
            }
            res = Math.max(res, total);
        }
        return res;
    }
}

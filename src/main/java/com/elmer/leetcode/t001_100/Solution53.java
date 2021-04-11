package com.elmer.leetcode.t001_100;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = nums[0], total = 0;
        for (int i = 0; i < n; i++) {
            total = Math.max(total + nums[i], nums[i]);
            res = Math.max(res, total);
        }
        return res;
    }
}

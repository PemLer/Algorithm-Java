package com.elmer.leetcode.offer;

public class Solution42 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int t = nums[0];
        for (int i = 1; i < nums.length; i++) {
            t = t < 0 ? nums[i] : t + nums[i];
            res = Math.max(res, t);
        }
        return res;
    }

}

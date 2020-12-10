package com.elmer.leetcode.t101_200;

public class Solution152 {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, minValue = 1, maxValue = 1, mx, mn;
        for (int num : nums) {
            mx = maxValue;
            mn = minValue;
            maxValue = Math.max(Math.max(mx * num, num), mn * num);
            minValue = Math.min(Math.min(mn * num, num), mx * num);
            res = Math.max(res, maxValue);
        }
        return res;
    }
}

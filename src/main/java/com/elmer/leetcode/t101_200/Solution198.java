package com.elmer.leetcode.t101_200;

public class Solution198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int pre1 = 0, pre2 = 0, tmp;

        for (int i = 0; i < n; i++) {
            tmp = Math.max(pre1 + nums[i], pre2);
            pre1 = pre2;
            pre2 = tmp;
        }
        return Math.max(pre1, pre2);
    }

}

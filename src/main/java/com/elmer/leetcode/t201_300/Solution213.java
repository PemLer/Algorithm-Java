package com.elmer.leetcode.t201_300;

public class Solution213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(getRes(nums, 0, n - 2), getRes(nums, 1, n - 1));
    }

    private int getRes(int[] nums, int i, int j) {
        int a = 0, b = 0, tmp;
        for (int k = i; k <= j; k++) {
            tmp = Math.max(a + nums[k], b);
            a = b;
            b = tmp;
        }
        return Math.max(a, b);
    }
}

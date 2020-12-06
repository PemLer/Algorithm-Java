package com.elmer.leetcode.t201_300;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int tmp = 1;
        for (int i = 0; i < n; i++) {
            res[i] = tmp;
            tmp *= nums[i];
        }
        tmp = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= tmp;
            tmp *= nums[i];
        }
        return res;
    }
}

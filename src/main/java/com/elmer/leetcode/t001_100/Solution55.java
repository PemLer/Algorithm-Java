package com.elmer.leetcode.t001_100;

public class Solution55 {
    public boolean canJump(int[] nums) {
        int n = nums.length, pos = nums[0];
        for (int i = 1; i < n; i++) {
            if (i > pos) return false;
            pos = Math.max(pos, i + nums[i]);
        }
        return true;
    }
}

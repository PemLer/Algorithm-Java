package com.elmer.leetcode.t001_100;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int p0 = 1, p1 = 1, n = nums.length;
        if (n <= 1) return n;
        while (p1 < n) {
            while (p1 < n && nums[p1] == nums[p1-1]) {
                p1++;
            }
            if (p1 < n) {
                set(nums, p0, p1);
                p1++;
                p0++;
            }
        }
        return p0;
    }

    private void set(int[] nums, int i, int j) {
        nums[i] = nums[j];
    }
}

package com.elmer.leetcode.t201_300;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        int p0 = 0, p1 = 0, n = nums.length;
        while (p1 < n) {
            if (p1 != p0) {
                if (nums[p1] != 0) {
                    swap(nums, p1, p0);
                    p1++;
                    p0++;
                } else {
                    p1++;
                }
            } else {
                if (nums[p1] != 0) {
                    p1++;
                    p0++;
                } else {
                    p1++;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

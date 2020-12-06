package com.elmer.leetcode.t001_100;

public class Solution75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0, i = 0;
        while (i < n) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, p1, i);
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
                i++;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

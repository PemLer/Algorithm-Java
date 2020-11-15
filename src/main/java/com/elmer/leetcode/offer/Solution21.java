package com.elmer.leetcode.offer;

public class Solution21 {
    public int[] exchange(int[] nums) {
        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                swap(nums, point, i);
                point++;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}

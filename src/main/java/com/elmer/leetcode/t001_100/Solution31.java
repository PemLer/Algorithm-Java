package com.elmer.leetcode.t001_100;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            reverse(nums, i + 1);
        } else {
            reverse(nums, 0);
        }

    }

    private void reverse(int[] nums, int start) {
        int n = nums.length - 1;
        for (int i = start; i <= start + (n - start) / 2; i++) {
            int idx = n - (i - start);
            int tmp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = tmp;
        }
    }
}

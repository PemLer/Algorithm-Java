package com.elmer.leetcode.t101_200;

public class Solution189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int startId, int endId) {
        while (startId < endId) {
            int tmp = nums[startId];
            nums[startId] = nums[endId];
            nums[endId] = tmp;
            startId++;
            endId--;
        }
    }
}

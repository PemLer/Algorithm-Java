package com.elmer.leetcode.t001_100;

public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

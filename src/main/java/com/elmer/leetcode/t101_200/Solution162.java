package com.elmer.leetcode.t101_200;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

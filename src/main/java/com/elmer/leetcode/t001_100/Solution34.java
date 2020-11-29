package com.elmer.leetcode.t001_100;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};
        int left = 0, right = n, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        int left_b = left;
        if (left == n) return new int[]{-1, -1};
        right = n;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) right = mid;
            else left = mid + 1;
        }
        if (left_b == left) return new int[]{-1, -1};
        return new int[]{left_b, left-1};
    }
}

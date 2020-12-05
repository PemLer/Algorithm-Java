package com.elmer.leetcode.t001_100;

public class Solution33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (nums[mid] > nums[n-1] && target < nums[n-1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] < nums[n-1] && target > nums[n-1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}

package com.elmer.leetcode.offer;

public class Solution53_1 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return 0;
        int i = 0, j = n, mid;
        while (i < j) {
            mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        int left = i;
        i = left;
        j = n;
        while (i < j) {
            mid = i + (j - i) / 2;
            if (nums[mid] > target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i - left;
    }
}

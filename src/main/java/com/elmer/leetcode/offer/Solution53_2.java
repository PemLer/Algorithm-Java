package com.elmer.leetcode.offer;

public class Solution53_2 {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == mid) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}

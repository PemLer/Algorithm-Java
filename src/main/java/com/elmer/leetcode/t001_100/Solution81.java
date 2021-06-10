package com.elmer.leetcode.t001_100;

public class Solution81 {
    public boolean search(int[] nums, int target) {
        // 4 5 6 1 2 3
        int n = nums.length;
        int left = 0, right = n - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left]) {  // 因为下面用到了n-1，所以不能用right；如果此处用right，下面判断就要用nums[0]
                left++;
                continue;
            }

            if (nums[mid] > target) {
                if (target <= nums[n - 1] && nums[mid] > nums[n-1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target > nums[n-1] && nums[mid] <= nums[n-1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}

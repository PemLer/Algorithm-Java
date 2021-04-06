package com.elmer.leetcode.t001_100;

import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int best = 10000;
        if (n < 3) {
            return -1;
        }
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1, right = n - 1, total;
            while (left < right) {
                total = nums[i] + nums[left] + nums[right];
                if (total == target) {
                    return total;
                } else if (total > target) {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                }
                if (Math.abs(total - target) < Math.abs(best - target)) {
                    best = total;
                }
            }
        }
        return best;
    }
}

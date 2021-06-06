package com.elmer.leetcode.offer;

import java.util.HashSet;
import java.util.Set;

public class Solution03 {
    public int findRepeatNumber(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int tmp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = tmp;
        }
        return -1;
    }
}

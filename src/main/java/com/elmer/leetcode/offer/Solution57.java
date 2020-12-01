package com.elmer.leetcode.offer;

import java.util.HashSet;
import java.util.Set;

public class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int total = nums[l] + nums[r];
            if (total > target) r--;
            else if (total < target) l++;
            else return new int[]{nums[l], nums[r]};
        }
        return new int[0];
    }
}

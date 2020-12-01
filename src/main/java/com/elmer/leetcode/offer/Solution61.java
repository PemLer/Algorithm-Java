package com.elmer.leetcode.offer;

import java.util.Arrays;

public class Solution61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zero++;
            else if (i > 0 && nums[i] == nums[i-1]) return false;
            else if (i > 0 && nums[i-1] != 0) zero -= (nums[i] - nums[i-1] - 1);
        }
        return zero >= 0;
    }
}

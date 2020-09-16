package com.elmer.leetcode.t001_100;

import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (record.containsKey(target - num)) {
                return new int[]{record.get(target-num), i};
            }
            record.put(num, i);
        }
        return new int[]{0, 0};
    }
}
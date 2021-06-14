package com.elmer.leetcode.t101_200;

public class Solution169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int res = nums[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    res = nums[i];
                    count++;
                }
            }
        }
        return res;
    }
}

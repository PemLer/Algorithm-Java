package com.elmer.leetcode.t001_100;

public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[index] = nums[i];
            index++;
        }
        return index;
    }
}

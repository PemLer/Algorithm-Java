package com.elmer.leetcode.t001_100;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow = 1, fast = 1;
        while (fast < n) {
            if (nums[fast] != nums[slow - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}

package com.elmer.leetcode.t001_100;

public class Solution75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        // p0, p1分别是下一个0和下一个1应该插入的位置
        int p0 = 0, p1 = 0, i = 0;
        while (i < n) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                // 如果p0小于p1，说明p0的位置当前是1
                if (p0 < p1) {
                    swap(nums, p1, i);
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                swap(nums, p1, i);
                p1++;
            }
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

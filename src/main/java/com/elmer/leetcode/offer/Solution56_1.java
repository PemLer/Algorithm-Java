package com.elmer.leetcode.offer;

public class Solution56_1 {
    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        int div = 1;
        while ((div & x) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & div) == 1) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
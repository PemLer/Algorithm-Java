package com.elmer.leetcode.offer;

public class Solution56_2 {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] += nums[i] & 1;
                nums[i] >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= bits[31 - i] % m;
        }
        return res;
    }
}

package com.elmer.leetcode.t101_200;

public class Solution137 {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bits[i]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }
}

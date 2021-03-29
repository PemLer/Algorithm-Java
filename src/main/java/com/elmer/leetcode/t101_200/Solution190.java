package com.elmer.leetcode.t101_200;

public class Solution190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                res |= (1 << (32 - i - 1));
            }
        }
        return res;
    }
}

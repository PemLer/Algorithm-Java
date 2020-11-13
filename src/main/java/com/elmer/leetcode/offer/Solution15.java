package com.elmer.leetcode.offer;

public class Solution15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) res++;
            n >>>= 1;
        }
        return res;
    }
}

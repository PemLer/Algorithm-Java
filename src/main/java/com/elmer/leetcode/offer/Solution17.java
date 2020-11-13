package com.elmer.leetcode.offer;

public class Solution17 {
    public int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 1; i <= end; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}

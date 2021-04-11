package com.elmer.leetcode.t201_300;

public class Solution263 {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = new int[]{2, 3, 5};
        for (int factor : factors) {
            while ((n % factor) == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}

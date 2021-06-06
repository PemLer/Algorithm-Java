package com.elmer.leetcode.t001_100;

public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }

        int sign = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            sign = -1;
        }
        long a = dividend, b = divisor;
        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;
        int res = div(a, b);
        return sign < 0 ? -res : res;
    }

    private int div(long a, long b) {
        if (a < b) return 0;
        int count = 1;
        long tb = b;
        while ((tb + tb) <= a) {
            count += count;
            tb += tb;
        }
        return count + div(a - tb, b);
    }
}

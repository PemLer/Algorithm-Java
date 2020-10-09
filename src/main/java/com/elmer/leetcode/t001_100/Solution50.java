package com.elmer.leetcode.t001_100;

public class Solution50 {
    public double myPow(double x, int n) {
        double res = 1;
        long b = n;
        boolean sign = true;
        if (b < 0) {
            sign = false;
            b = -b;
        }

        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x = x * x;
            b >>= 1;
        }
        return sign ? res : 1 / res;
    }
}

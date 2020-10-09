package com.elmer.leetcode.offer;

public class Solution16 {
    public double myPow(double x, int n) {
        boolean sign = true;
        long b = n;
        if (b < 0) {
            sign = false;
            b = -b;
        }
        double res = 1;
        double t = x;
        while (b != 0) {
            if ((b & 1) == 1) {
                res *= t;
            }
            b = b >> 1;
            t = t * t;
        }
        return sign ? res : 1/res;
    }

    public static void main(String[] args) {
        Solution16 sol = new Solution16();
        sol.myPow(2, 10);
    }
}

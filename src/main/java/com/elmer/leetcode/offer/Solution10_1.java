package com.elmer.leetcode.offer;

public class Solution10_1 {

    private int mod = 1000000007;

    public int fib(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, t;
        for (int i = 2; i <= n; i++) {
            t = a;
            a = b;
            b = (t + a) % mod;
        }
        return b;
    }
}

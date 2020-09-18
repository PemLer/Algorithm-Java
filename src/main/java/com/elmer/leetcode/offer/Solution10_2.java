package com.elmer.leetcode.offer;

public class Solution10_2 {
    private int mod = 1000000007;

    public int numWays(int n) {
        if (n <= 1) return 1;
        int a = 1, b = 1, t;
        for (int i = 2; i <= n; i++) {
            t = a;
            a = b;
            b = (t + a) % mod;
        }
        return b;
    }
}

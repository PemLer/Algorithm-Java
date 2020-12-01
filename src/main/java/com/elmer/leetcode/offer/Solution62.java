package com.elmer.leetcode.offer;

public class Solution62 {
    public int lastRemaining(int n, int m) {
        if (n == 1) return 0;
        int x = lastRemaining(n - 1, m);
        return (x + m % n) % n;
    }
}

package com.elmer.leetcode.t001_100;

public class Solution70 {
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int a = 1, b = 2, tmp;
        for (int i = 3; i <= n; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }
}

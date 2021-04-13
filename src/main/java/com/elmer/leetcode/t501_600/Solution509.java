package com.elmer.leetcode.t501_600;

public class Solution509 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int a = 0, b = 1, tmp;
        for (int i = 2; i <= n; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }
}

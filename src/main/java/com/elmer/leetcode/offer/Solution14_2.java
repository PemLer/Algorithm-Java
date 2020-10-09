package com.elmer.leetcode.offer;

public class Solution14_2 {

    private int mod = 1000000007;

    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        long a = n / 3, b = n % 3;
        if (b == 0) return (int) qmi(3, a);
        else if (b == 1) return (int) (qmi(3, a - 1) * 4 % mod);
        else return (int) (qmi(3, a) * 2 % mod);
    }

    private long qmi(long x, long n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return res % mod;
    }
}

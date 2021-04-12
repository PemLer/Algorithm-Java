package com.elmer.leetcode.t801_;

public class Solution1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        if (a == 1 || b == 1 || c == 1) return n;

        // 两两组合的最小公倍数
        long lcmAB = lcm(a, b);
        long lcmAC = lcm(a, c);
        long lcmBC = lcm(b, c);

        long lcmABC = lcm(lcmAB, c);
        int min = Math.min(Math.min(a, b), c);
        long left = min, right = (long) Math.pow(min, n), mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            long count = mid / a + mid / b + mid / c - mid / lcmAB - mid / lcmAC - mid / lcmBC + mid / lcmABC;
            if (count == n) {
                left = mid;
                break;
            } else if (count < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int)(left - Math.min(Math.min(left % a,left % b),left % c));
    }

    // 最小公倍数
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    // 最大公因数
    private long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}

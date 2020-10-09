package com.elmer.leetcode.t201_300;

public class Solution233 {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int high = n / 10, low = 0, res = 0, cur = n % 10, digit = 1;
        while (high != 0 || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}

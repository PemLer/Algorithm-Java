package com.elmer.leetcode.t001_100;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n - 1, carry = 1;
        while (i >= 0) {
            int t = digits[i];
            digits[i] = (carry + digits[i]) % 10;
            carry = (carry + t) / 10;
            i--;
        }
        if (carry == 1) {
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}

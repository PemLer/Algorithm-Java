package com.elmer.leetcode.t001_100;

public class Solution8 {
    public int myAtoi(String s) {
        s = s.trim();
        if ("".equals(s)) return 0;
        int i = 0;
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+') i++;
        long res = 0;
        for (int k = i; k < s.length(); k++) {
            char c = s.charAt(k);
            if (c < '0' || c > '9') break;
            else {
                res = res * 10 + (c - '0');
                if (sign == 1 && res > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (sign == -1 && res * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return (int) res * sign;
    }
}

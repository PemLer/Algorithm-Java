package com.elmer.leetcode.offer;

public class Solution67 {
    public int strToInt(String str) {
        if (str.length() == 0) return 0;
        int i = 0;
        char[] chars = str.toCharArray();
        while (chars[i] == ' ') {
            i++;
            if (i == chars.length) return 0;
        }
        int sign = 1;
        int res = 0, brndry = Integer.MAX_VALUE / 10;
        if (chars[i] == '-') sign = -1;
        if (chars[i] == '+' || chars[i] == '-') i++;
        for (int k = i; k < chars.length; k++) {
            if (chars[k] < '0' || chars[k] > '9') break;
            if (res > brndry || res == brndry && chars[k] > '7') return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            res = res * 10 + (chars[k] - '0');
        }
        return res * sign;
    }
}

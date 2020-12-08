package com.elmer.leetcode.t101_200;

public class Solution171 {
    public int titleToNumber(String s) {
        int res = 0, i = 0, n = s.length();
        while (i < n) {
            res = res * 26 + (s.charAt(i) - 'A');
            i++;
        }
        return res;
    }
}

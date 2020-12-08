package com.elmer.leetcode.t101_200;

public class Solution168 {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            n--;
            int val = n % 26;
            builder.append((char) (val + 'A'));
            n /= 26;
        }
        builder.reverse();
        return builder.toString();
    }
}

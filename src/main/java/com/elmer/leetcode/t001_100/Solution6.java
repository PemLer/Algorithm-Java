package com.elmer.leetcode.t001_100;

public class Solution6 {
    public String convert(String s, int numRows) {
        /*
        1   7     13
        2 6 8  12 14
        3 5 9  11 15
        4   10    16

        1   5
        2 4 6
        3   7

        1   9
        2 8 10
        3 7 11
        4 6 12
        5   13
         */
        if (numRows == 1) {
            return s;
        }
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int cur = i, gap = 2 * (numRows - 1);
            if (i == 0 || i == numRows - 1) {
                while (cur < n) {
                    sb.append(s.charAt(cur));
                    cur += gap;
                }
            } else {
                int d1 = (numRows - i - 1) * 2;
                int d2 = gap - d1;
                int d = d1;
                while (cur < n) {
                    sb.append(s.charAt(cur));
                    cur += d;
                    d = d == d1 ? d2 : d1;
                }
            }
        }
        return sb.toString();
    }
}

package com.elmer.leetcode.t001_100;

public class Solution14 {
//    public String longestCommonPrefix(String[] strs) {
//        int n = strs.length;
//        if (n == 0) {
//            return "";
//        }
//        int j = strs[0].length();
//        String base = strs[0];
//        for (int k = 1; k < n; k++) {
//            j = check(j, base, strs[k]);
//            if (j == 0) {
//                return "";
//            }
//        }
//        return base.substring(0, j);
//    }
//
//    private int check(int j, String s1, String s2) {
//        for (int i = 0; i < j; i++) {
//            if (i >= s2.length() || s1.charAt(i) != s2.charAt(i)) {
//                return i;
//            }
//        }
//        return j;
//    }

    // 分治
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) {
            return "";
        }
        return divideProcess(strs, 0, n - 1);
    }

    private String divideProcess(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }
        int mid = start + (end - start) / 2;
        String left = divideProcess(strs, start, mid);
        String right = divideProcess(strs, mid + 1, end);
        int j = Math.min(left.length(), right.length());
        for (int i = 0; i < j; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, j);
    }
}

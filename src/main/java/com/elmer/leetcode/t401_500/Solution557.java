package com.elmer.leetcode.t401_500;

public class Solution557 {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        String[] ss = s.split(" ");
        for (String s1 : ss) {
            int p = s1.length() - 1;
            while (p >= 0) {
                builder.append(s1.charAt(p));
                p--;
            }
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}

package com.elmer.leetcode.t101_200;

import java.util.LinkedList;
import java.util.List;

public class Solution151 {
    public String reverseWords(String s) {
        LinkedList<String> list = new LinkedList<>();
        int i = 0, n = s.length();
        while (i < n) {
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }
            StringBuilder builder = new StringBuilder();
            while (i < n && s.charAt(i) != ' ') {
                builder.append(s.charAt(i));
                i++;
            }
            if (builder.length() > 0)
                list.addFirst(builder.toString());
        }
        return String.join(" ", list);
    }
}

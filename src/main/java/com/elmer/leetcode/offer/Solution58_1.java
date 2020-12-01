package com.elmer.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution58_1 {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        int i = 0, start;
        while (i < s.length()) {
            start = i;
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
            if (start != i) {
                list.add(s.substring(start, i));
            }
            i++;
        }
        for (int k = 0; k < list.size() / 2; k++) {
            String t = list.get(k);
            list.set(k, list.get(list.size() - k - 1));
            list.set(list.size() - k - 1, t);
        }
        return String.join(" ", list);
    }
}

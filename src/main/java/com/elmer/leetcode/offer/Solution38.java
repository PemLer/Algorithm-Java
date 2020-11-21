package com.elmer.leetcode.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution38 {
    char[] chars;
    List<String> res;
    public String[] permutation(String s) {
        chars = s.toCharArray();
        res = new ArrayList<>();
        dfs(0);
        return res.toArray(new String[0]);
    }

    private void dfs(int x) {
        if (x == chars.length - 1) {
            res.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i,  x);
        }
    }

    private void swap(int a, int b) {
        char c = chars[a];
        chars[a] = chars[b];
        chars[b] = c;
    }

}

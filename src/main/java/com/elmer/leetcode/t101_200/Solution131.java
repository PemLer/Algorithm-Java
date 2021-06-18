package com.elmer.leetcode.t101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution131 {
    String s;
    List<List<String>> res;
    List<String> tmp;
    boolean[][] mem;
    public List<List<String>> partition(String s) {
        this.s = s;
        res = new ArrayList<>();
        tmp = new ArrayList<>();
        int n = s.length();
        mem = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mem[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                mem[i][j] = s.charAt(i) == s.charAt(j) && mem[i+1][j-1];
            }
        }

        dfs(0, 0);
        return res;
    }

    private void dfs(int i, int useLength) {
        if (i == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int x = i + 1; x <= s.length(); x++) {
            if (mem[i][x - 1]) {
                tmp.add(s.substring(i, x));
                dfs(x, useLength + (x - i));
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}

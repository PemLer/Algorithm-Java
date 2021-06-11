package com.elmer.leetcode.t101_200;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    String s;
    List<List<String>> res;
    List<String> tmp;
    int[][] mem;
    public List<List<String>> partition(String s) {
        this.s = s;
        res = new ArrayList<>();
        tmp = new ArrayList<>();
        mem = new int[s.length()][s.length()];
        dfs(0, 0);
        return res;
    }

    private void dfs(int i, int useLength) {
        if (i == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int x = i + 1; x <= s.length(); x++) {
            if (isValid(i, x - 1)) {
                tmp.add(s.substring(i, x));
                dfs(x, useLength + (x - i));
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean isValid(int start, int end) {
        if (mem[start][end] == 1) {
            return true;
        } else if (mem[start][end] == -1) {
            return false;
        }
        int i = start, j = end;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                mem[start][end] = -1;
                return false;
            }
            i++;
            j--;
        }
        mem[start][end] = 1;
        return true;
    }
}

package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    List<String> res;
    int n;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        this.n = n;
        dfs(n, n, new ArrayList<>());
        return res;
    }

    private void dfs(int open, int close, List<String> tmp) {
        if (open == 0 && close == 0) {
            res.add(String.join("", tmp));
            return;
        }
        if (open > 0) {
            tmp.add("(");
            dfs(open - 1, close, tmp);
            tmp.remove(tmp.size() - 1);
        }
        if (close > open) {
            tmp.add(")");
            dfs(open, close - 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}

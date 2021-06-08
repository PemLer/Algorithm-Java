package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {

    int n, k;
    List<List<Integer>> res;
    List<Integer> tmp;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        res = new ArrayList<>();
        tmp = new ArrayList<>(k);
        dfs(1);
        return res;
    }

    private void dfs(int x) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = x; i <= n; i++) {
            // 剪枝：当剩下需要遍历的元素个数全部用完也不足以形成可行结果时，则返回
            // n - (i + 1) + 1 < k - (tmp.size() + 1) => n - i < k - tmp.size() - 1
            if (n - i < k - tmp.size() - 1) {
                break;
            }
            tmp.add(i);
            dfs(i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

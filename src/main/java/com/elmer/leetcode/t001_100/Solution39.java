package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.List;

public class Solution39 {
    int[] candidates;
    int target;
    List<Integer> tmp;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        tmp = new ArrayList<>();
        res = new ArrayList<>();
        dfs(0, 0);
        return res;
    }

    private void dfs(int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int total = sum + candidates[i];
            if (total <= target) {
                tmp.add(candidates[i]);
                dfs(i, total);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}

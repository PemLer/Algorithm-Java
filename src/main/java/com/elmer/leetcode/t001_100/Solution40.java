package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {

    List<List<Integer>> res;
    List<Integer> tmp;
    int target;
    int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        tmp = new ArrayList<>();
        this.target = target;
        Arrays.sort(candidates);
        this.candidates = candidates;
        dfs(0, 0);
        return res;
    }

    private void dfs(int i, int total) {
        if (total == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int k = i; k < candidates.length; k++) {
            if (k > i && candidates[k] == candidates[k-1]) {
                continue;
            }
            int sum = total + candidates[k];
            if (sum <= target) {
                tmp.add(candidates[k]);
                dfs(k + 1, sum);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}

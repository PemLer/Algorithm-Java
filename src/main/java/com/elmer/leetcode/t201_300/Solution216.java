package com.elmer.leetcode.t201_300;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {

    List<List<Integer>> res;
    List<Integer> tmp;
    int target;
    int k;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        tmp = new ArrayList<>();
        target = n;
        this.k = k;
        dfs(1, 0, 0);
        return res;
    }

    private void dfs(int i, int total, int count) {
        if (count == k && total == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (count == k) {
            return;
        }

        for (int j = i; j < 10; j++) {
            int sum = total + j;
            if (sum > target || count + 1 > k || sum == target && count + 1 < k || sum < target && count + 1 == k) {
                continue;
            }
            tmp.add(j);
            dfs(j + 1, sum, count + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

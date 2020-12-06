package com.elmer.leetcode.t001_100;

import java.util.*;

public class Solution46 {

    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        dfs(list, 0);
        return res;
    }

    private void dfs(List<Integer> nums, int n) {
        if (n == nums.size()) {
            res.add(new ArrayList<>(nums));
            return;
        }

        for (int i = n; i < nums.size(); i++) {
            swap(nums, i, n);
            dfs(nums, n + 1);
            swap(nums, i, n);
        }
    }

    private void swap(List<Integer> nums, int i, int j) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }
}

package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution47 {

    boolean[] visit;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        visit = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, List<Integer> sub, List<List<Integer>> res) {
        if (sub.size() == nums.length) {
            res.add(new ArrayList<>(sub));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visit[i] || (i > 0 && nums[i-1] == nums[i] && !visit[i-1])) {
                continue;
            }

            sub.add(nums[i]);
            visit[i] = true;
            dfs(nums, sub, res);
            sub.remove(sub.size() - 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,1};
        Solution47 sol = new Solution47();
        sol.permuteUnique(nums);
    }

}

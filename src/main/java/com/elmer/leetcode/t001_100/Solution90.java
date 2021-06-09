package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {
    List<List<Integer>> res;
    List<Integer> tmp;
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        tmp = new ArrayList<>();
        Arrays.sort(nums);
        this.nums = nums;
        dfs(0, false);
        return res;
    }

    // 如果前面没有选，则当前也不选
    private void dfs(int x, boolean choosePre) {
        // 1 2 2
        // [] [1 2] [1 2 2] [1]
        if (x == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        dfs(x + 1, false);
        if (!choosePre && x > 0 && nums[x] == nums[x - 1]) {
            return;
        }
        tmp.add(nums[x]);
        dfs(x + 1, true);
        tmp.remove(tmp.size() - 1);
    }
}

package com.elmer.leetcode.offer;

import com.elmer.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution34 {
    List<List<Integer>> res;
    List<Integer> tmp;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        tmp = new ArrayList<>();
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int tar) {
        if (root == null) {
            return;
        }
        tar -= root.val;
        tmp.add(root.val);
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(tmp));
        }
        dfs(root.left, tar);
        dfs(root.right, tar);
        tmp.remove(tmp.size() - 1);
    }
}

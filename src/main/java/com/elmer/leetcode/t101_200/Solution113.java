package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    List<List<Integer>> res;
    List<Integer> tmp;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        tmp = new ArrayList<>();
        target = targetSum;
        if (root == null) {
            return res;
        }
        tmp.add(root.val);
        dfs(root, root.val);
        tmp.remove(tmp.size() - 1);
        return res;
    }

    private void dfs(TreeNode node, int total) {
        if (node.left == null && node.right == null) {
            if (total == target) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        if (node.left != null) {
            int val = node.left.val;
            tmp.add(val);
            dfs(node.left, total + val);
            tmp.remove(tmp.size() - 1);
        }
        if (node.right != null) {
            int val = node.right.val;
            tmp.add(val);
            dfs(node.right, total + val);
            tmp.remove(tmp.size() - 1);
        }
    }

}

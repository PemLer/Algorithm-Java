package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

public class Solution104 {
    int res;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = 0;
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int deep) {
        if (root.left == null && root.right == null) {
            res = Math.max(res, deep);
            return;
        }
        if (root.left != null) {
            dfs(root.left, deep + 1);
        }
        if (root.right != null) {
            dfs(root.right, deep + 1);
        }
    }
}

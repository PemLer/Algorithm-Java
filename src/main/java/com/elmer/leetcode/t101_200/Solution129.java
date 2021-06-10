package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

public class Solution129 {
    int total;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        total = 0;
        dfs(root, root.val);
        return total;
    }

    private void dfs(TreeNode root, int tmp) {
        if (root.left == null && root.right == null) {
            total += tmp;
            return;
        }
        if (root.left != null) {
            dfs(root.left, tmp * 10 + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, tmp * 10 + root.right.val);
        }
    }
}

package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(deep(root.left) - deep(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(deep(root.left), deep(root.right));
    }
}

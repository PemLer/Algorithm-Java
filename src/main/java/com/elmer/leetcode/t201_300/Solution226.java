package com.elmer.leetcode.t201_300;

import com.elmer.leetcode.common.TreeNode;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) return;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invert(root.left);
        invert(root.right);
    }
}

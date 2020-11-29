package com.elmer.leetcode.offer;

import com.elmer.leetcode.common.TreeNode;

public class Solution55_2 {
    public boolean isBalanced(TreeNode root) {
        return isBalance(root) != -1;
    }

    private int isBalance(TreeNode root) {
        if (root == null) return 0;
        int left = isBalance(root.left);
        if (left == -1) return -1;
        int right = isBalance(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}

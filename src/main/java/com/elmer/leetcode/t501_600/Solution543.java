package com.elmer.leetcode.t501_600;

import com.elmer.leetcode.common.TreeNode;

public class Solution543 {
    private int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        dp(root);
        return res;
    }

    private int dp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dp(root.left);
        int right = dp(root.right);
        res = Math.max(res, left + right);

        return Math.max(left, right) + 1;
    }
}

package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

public class Solution124 {

    private int res;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        res = Math.max(res, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}

package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

public class Solution112 {
    int target;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        if (root == null) {
            return targetSum == 0;
        }
        return isFound(root, root.val);
    }

    private boolean isFound(TreeNode root, int total) {
        if (root.left == null && root.right == null) {
            return total == target;
        }
        boolean f1 = false, f2 = false;
        if (root.left != null) {
            f1 = isFound(root.left, total + root.left.val);
        }
        if (root.right != null) {
            f2 = isFound(root.right, total + root.right.val);
        }
        return f1 || f2;
    }
}

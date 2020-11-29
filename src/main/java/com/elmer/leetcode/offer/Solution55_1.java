package com.elmer.leetcode.offer;

import com.elmer.leetcode.common.TreeNode;

public class Solution55_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

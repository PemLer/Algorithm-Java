package com.elmer.leetcode.offer;

import com.elmer.leetcode.common.TreeNode;

public class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    private boolean check(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        if (A.val == B.val) return check(A.left, B.right) && check(A.right, B.left);
        else return false;
    }
}

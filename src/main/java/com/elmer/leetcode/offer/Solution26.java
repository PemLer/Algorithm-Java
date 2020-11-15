package com.elmer.leetcode.offer;

import com.elmer.leetcode.common.TreeNode;

public class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        if (A.val == B.val && isSame(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSame(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return isSame(A.left, B.left) && isSame(A.right, B.right);
    }
}

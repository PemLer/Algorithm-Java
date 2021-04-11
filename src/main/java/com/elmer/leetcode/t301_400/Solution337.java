package com.elmer.leetcode.t301_400;

import com.elmer.leetcode.common.TreeNode;

public class Solution337 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        int[] res = {0, 0};
        if (root == null) {
            return res;
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);


        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}

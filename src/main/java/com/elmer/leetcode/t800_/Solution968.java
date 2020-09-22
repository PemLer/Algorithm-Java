package com.elmer.leetcode.t800_;

import com.elmer.leetcode.common.TreeNode;

/*
    每个节点有三种状态
    对于root节点：
        a 覆盖整棵树需要的摄像头，root必须放置摄像头
        b 覆盖整棵树需要的摄像头，root可放可不放
        c 覆盖root的子树需要的摄像头，不管root是否覆盖
    对于root的左右子树，其状态分别为(la, lb, lc)和(ra, rb, rc)
        a = 1 + lc + rc
        b = min(a, min(la + rb, lb + ra))

 */

public class Solution968 {
    public int minCameraCover(TreeNode root) {
        return dfs(root)[1];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int a = 1 + left[2] + right[2];
        int b = Math.min(a, Math.min(left[0] + right[1], left[1] + right[0]));
        int c = Math.min(a, left[1] + right[1]);
        return new int[]{a, b, c};
    }

}

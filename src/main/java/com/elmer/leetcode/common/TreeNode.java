package com.elmer.leetcode.common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode creatTree() {
        TreeNode root0 = new TreeNode(4);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(5);
        TreeNode root4 = new TreeNode(6);
        root0.left = root1;
        root1.right = root2;
        root0.right = root4;
        root4.left = root3;
        return root0;
    }
}
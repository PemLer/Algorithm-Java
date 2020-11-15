package com.elmer.leetcode.offer;

import com.elmer.leetcode.common.TreeNode;

import java.util.Stack;

public class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

//    // 方法二
//    public TreeNode mirrorTree(TreeNode root) {
//        if (root == null) return root;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.add(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node.left != null) stack.add(node.left);
//            if (node.right != null) stack.add(node.right);
//            TreeNode t = node.left;
//            node.left = node.right;
//            node.right = t;
//        }
//        return root;
//    }
}

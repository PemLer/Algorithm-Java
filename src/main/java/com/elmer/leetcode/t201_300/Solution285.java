package com.elmer.leetcode.t201_300;

import com.elmer.leetcode.common.TreeNode;

import java.util.Stack;

public class Solution285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        Stack<TreeNode> stack = new Stack<>();
        boolean isFound = false;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (isFound) {
                return root;
            }
            if (root == p) {
                isFound = true;
            }
            root = root.right;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution285 sol = new Solution285();
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        l2.left = l1;
        l2.right = l3;
        sol.inorderSuccessor(l2, l2);
    }
}

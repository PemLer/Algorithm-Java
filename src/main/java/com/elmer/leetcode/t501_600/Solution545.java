package com.elmer.leetcode.t501_600;

import com.elmer.leetcode.common.TreeNode;

import java.util.*;

public class Solution545 {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        addLeft(root.left, res);
        addLeaf(root.left, res);
        addLeaf(root.right, res);
        addRight(root.right, res);
        return res;
    }

    private void addLeft(TreeNode root, List<Integer> res) {
        while (root != null) {
            int val = root.val;
            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                break;
            }
            res.add(val);
        }
    }

    private void addRight(TreeNode root, List<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        while (root != null) {
            int val = root.val;
            if (root.right != null) {
                root = root.right;
            } else if (root.left != null) {
                root = root.left;
            } else {
                break;
            }
            stack.add(val);
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    private void addLeaf(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        addLeaf(root.left, res);
        addLeaf(root.right, res);
    }
}

package com.elmer.leetcode.t401_500;

import com.elmer.leetcode.common.TreeNode;

public class Solution450 {

    // 后继节点的值
    private int successor(TreeNode node) {
        node = node.right;
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    // 前驱节点的值
    private int predecessor(TreeNode node) {
        node = node.left;
        while (node != null && node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else if (root.left != null) {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            } else {
                root = null;
            }
        }
        return root;
    }
}

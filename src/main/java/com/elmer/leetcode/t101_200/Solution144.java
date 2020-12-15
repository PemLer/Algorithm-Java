package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution144 {
    // Mirror
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        TreeNode predecessor;
//        while (root != null) {
//            if (root.left != null) {
//                predecessor = root.left;
//                while (predecessor.right != null && predecessor.right != root) {
//                    predecessor = predecessor.right;
//                }
//                if (predecessor.right == null) {
//                    res.add(root.val);
//                    predecessor.right = root;
//                    root = root.left;
//                } else {
//                    predecessor.right = null;
//                    root = root.right;
//                }
//            } else {
//                res.add(root.val);
//                root = root.right;
//            }
//        }
//        return res;
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.val);
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}

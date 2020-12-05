package com.elmer.leetcode.t001_100;

import com.elmer.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution98 {

//    // 中序遍历
//    public boolean isValidBST(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        long pre = Integer.MIN_VALUE - 1L;
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.add(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (root.val <= pre) return false;
//            pre = root.val;
//            root = root.right;
//        }
//        return true;
//    }

    // 递归
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
    }

    private boolean isValid(TreeNode root, long low, long high) {
        if (root == null) return true;
        int val = root.val;
        if (val < low || val > high) return false;
        return isValid(root.left, low, val) && isValid(root.right, val, high);
    }

}

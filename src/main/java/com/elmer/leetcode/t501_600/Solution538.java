package com.elmer.leetcode.t501_600;

import com.elmer.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 将二叉搜索树转化为累加树，每个节点的值等于本身值加上所有大于本节点值的和
// 先遍历右节点的中序遍历

public class Solution538 {

//    // 方法一 递归
//    private int total;
//
//    public TreeNode convertBST(TreeNode root) {
//        total = 0;
//        postTravel(root);
//        return root;
//    }
//
//    private void postTravel(TreeNode root) {
//        if (root == null) return;
//        postTravel(root.right);
//        int tmp = root.val;
//        root.val += total;
//        total += tmp;
//        postTravel(root.left);
//    }

    // 方法二 迭代
    private int total;

    public TreeNode convertBST(TreeNode root) {
        total = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = root;
        int tmp;
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.right;
            } else {
                root = stack.pop();
                tmp = root.val;
                root.val += total;
                total += tmp;
                root = root.left;
            }
        }
        return head;
    }
}

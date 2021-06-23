package com.elmer.leetcode.t001_100;

import com.elmer.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution99 {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode x = null, y = null, pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val < pre.val) {
                y = root;
                if (x == null) {
                    x = pre;
                } else {
                    break;
                }
            }
            pre = root;
            root = root.right;
        }

        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }
}

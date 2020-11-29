package com.elmer.leetcode.offer;

import com.elmer.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution54 {
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                list.add(node.val);
                root = node.right;
            }
        }
        return list.get(list.size() - k);
    }
}

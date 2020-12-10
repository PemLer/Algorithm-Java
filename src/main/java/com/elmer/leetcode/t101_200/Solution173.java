package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution173 {

}

class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        toMostLeft(root);
    }

    private void toMostLeft(TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        toMostLeft(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
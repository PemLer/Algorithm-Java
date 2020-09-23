package com.elmer.leetcode.offer;

import java.util.Stack;

// 二叉搜索树转双向循环链表
// 中序遍历
public class Solution36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Stack<Node> stack = new Stack<>();
        Node pre = null, first = null;
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (pre == null) {
                    first = root;
                } else {
                    pre.right = root;
                    root.left = pre;
                }
                pre = root;
                root = root.right;
            }
        }
        // 连接首尾
        first.left = pre;
        pre.right = first;
        return first;
    }
}

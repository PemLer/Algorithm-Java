package com.elmer.leetcode.t101_200;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution116 {
    public Node connect(Node root) {
        Node first = root, cur, pre;
        while (first != null) {
            cur = first;
            first = cur.left;
            pre = null;
            while (cur != null) {
                if (pre != null) {
                    pre.next = cur.left;
                }
                pre = cur.left;
                pre.next = cur.right;
                pre = cur.right;
                cur = cur.next;
            }
        }
        return root;
    }
}

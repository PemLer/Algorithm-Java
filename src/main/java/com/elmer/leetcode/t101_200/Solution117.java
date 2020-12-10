package com.elmer.leetcode.t101_200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution117 {
    public Node connect(Node root) {
        Node cur = root;
        while (cur != null) {
            Node pre = null, nextStart = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (pre == null) {
                        pre = cur.left;
                        nextStart = cur.left;
                    } else {
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                if (cur.right != null) {
                    if (pre == null) {
                        pre = cur.right;
                        nextStart = cur.right;
                    } else {
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                cur = cur.next;
            }
            cur = nextStart;
        }
        return root;
    }
}

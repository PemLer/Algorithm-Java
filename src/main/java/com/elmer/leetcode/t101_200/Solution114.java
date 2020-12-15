package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution114 {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }
}

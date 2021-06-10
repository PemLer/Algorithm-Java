package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

import java.util.*;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            Queue<TreeNode> sub = new LinkedList<>();
            for (TreeNode node : queue) {
                tmp.add(node.val);
                if (node.left != null) {
                    sub.add(node.left);
                }
                if (node.right != null) {
                    sub.add(node.right);
                }
            }
            res.add(0, tmp);
            queue = sub;
        }
        return res;
    }
}

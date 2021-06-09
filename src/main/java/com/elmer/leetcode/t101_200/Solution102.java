package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
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
            queue = sub;
            res.add(tmp);
        }
        return res;
    }
}

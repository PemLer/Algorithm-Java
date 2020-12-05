package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

import java.util.*;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        int layer = 0;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            for (TreeNode node : queue) {
                tmp.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            queue = q;
            layer++;
            if (layer % 2 == 0) {
                Collections.reverse(tmp);
            }
            res.add(tmp);
        }
        return res;
    }
}

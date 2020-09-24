package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor;
        while (root != null) {
            predecessor = root.right;
            if (root.right != null) {
                while (predecessor.left != null && predecessor.left != root) {
                    predecessor = predecessor.left;
                }
                if (predecessor.left == null) {
                    res.add(root.val);
                    predecessor.left = root;
                    root = root.right;
                } else {
                    predecessor.left = null;
                    root = root.left;
                }
            } else {
                res.add(root.val);
                root = root.left;
            }
        }
        Collections.reverse(res);
        return res;
    }
}

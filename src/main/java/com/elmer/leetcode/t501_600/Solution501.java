package com.elmer.leetcode.t501_600;

import com.elmer.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution501 {

    private int val, c, max;
    private List<Integer> res;

    public int[] findMode(TreeNode root) {
        val = Integer.MIN_VALUE;
        c = 1;
        max = 1;
        res = new ArrayList<>();
        inorder(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    // Morris算法
    private void inorder(TreeNode root) {
        TreeNode predecessor;
        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    update(root);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                update(root);
                root = root.right;
            }
        }
    }

    private void update(TreeNode root) {
        c  = root.val == val ? c + 1 : 1;
        if (c == max) {
            res.add(root.val);
        } else if (c > max) {
            max = c;
            res.clear();
            res.add(root.val);
        }
        val = root.val;
    }
}

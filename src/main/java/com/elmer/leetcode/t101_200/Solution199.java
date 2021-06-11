package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution199 {
    int layer = 0;
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode node, int layer) {
        if (node == null) {
            return;
        }
        if (layer > this.layer) {
            this.layer = layer;
            res.add(node.val);
        }
        dfs(node.right, layer + 1);
        dfs(node.left, layer + 1);
    }
}

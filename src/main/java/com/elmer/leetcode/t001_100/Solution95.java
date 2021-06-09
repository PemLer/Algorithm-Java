package com.elmer.leetcode.t001_100;

import com.elmer.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution95 {

    public List<TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }

    private List<TreeNode> buildTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);  // !!! 必须加 null，否则下面的循环为空，循环不起来
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = buildTree(start, i - 1);
            List<TreeNode> rights = buildTree(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}

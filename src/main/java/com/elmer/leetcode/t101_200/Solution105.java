package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode helper(int[] preorder, int m, int n, int[] inorder, int i, int j, Map<Integer, Integer> map) {
        if (m > n) return null;
        int val = preorder[m];
        int idx = map.get(val);
        TreeNode node = new TreeNode(val);
        int len = j - idx;
        node.left = helper(preorder, m + 1, n - len, inorder, i, idx - 1, map);
        node.right = helper(preorder, n - len + 1, n, inorder, idx + 1, j, map);
        return node;
    }
}

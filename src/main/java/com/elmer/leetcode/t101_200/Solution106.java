package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree1(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode buildTree1(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd) return null;
        int val = postorder[poEnd];
        int idx = map.get(val);
        TreeNode root = new TreeNode(val);
        int len = idx - inStart;
        root.right = buildTree1(inorder, idx + 1, inEnd, postorder, poStart + len, poEnd - 1, map);
        root.left = buildTree1(inorder, inStart, idx - 1, postorder, poStart, poStart + len - 1, map);
        return root;
    }
}

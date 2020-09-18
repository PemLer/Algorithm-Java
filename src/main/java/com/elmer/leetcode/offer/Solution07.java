package com.elmer.leetcode.offer;

import com.elmer.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn, Map<Integer, Integer> map) {
        if (startPre > endPre) return null;
        int val = preorder[startPre];
        TreeNode root = new TreeNode(val);
        int idx = map.get(val);
        int leftNodes = idx - startIn, rightNodes = endIn - idx;
        root.left = buildTree(preorder, startPre + 1, startPre + leftNodes, inorder, startIn, idx-1, map);
        root.right = buildTree(preorder, endPre - rightNodes + 1, endPre, inorder, idx+1, endIn, map);
        return root;
    }

}

package com.elmer.leetcode.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinaryTreeUtil {

    public static TreeNode getNode(int val, Map<Integer, TreeNode> map) {
        if (val == 0) return null;
        TreeNode node;
        if (map.containsKey(val)) {
            node = map.get(val);
        } else {
            node = new TreeNode(val);
            map.put(val, node);
        }
        return node;
    }

    public static TreeNode buildTree(int n, Scanner in) {
        TreeNode root = null, faNode, lcNode, rcNode;
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] vals = in.nextLine().split(" ");
            int fa = Integer.parseInt(vals[0]);
            int lc = Integer.parseInt(vals[1]);
            int rc = Integer.parseInt(vals[2]);
            faNode = getNode(fa, map);
            lcNode = getNode(lc, map);
            rcNode = getNode(rc, map);
            if (root == null) {
                root = faNode;
            }
            if (faNode != null) {
                faNode.left = lcNode;
                faNode.right = rcNode;
            }
        }
        return root;
    }
}

package com.elmer.leetcode.guide.binary_tree;

import com.elmer.leetcode.common.TreeNode;
import static com.elmer.leetcode.common.BinaryTreeUtil.*;

import java.util.Scanner;

public class Main_2 {

    public static String getBoundary1(TreeNode root) {
        if (root == null) return "";
        int deep = getDeep(root);
        TreeNode[][] edge = new TreeNode[deep][2];
        getEdge(edge, root, 0);
        StringBuilder builder = new StringBuilder();
        // left
        for (int i = 0; i < deep; i++) {
            builder.append(edge[i][0].val).append(" ");
        }
        // leaf
        getLeaf(root,0, edge, builder);
        // right
        for (int i = deep - 1; i >= 0; i--) {
            if (edge[i][1] != edge[i][0]) {
                builder.append(edge[i][1].val).append(" ");
            }
        }
        return builder.toString();
    }

    private static int getDeep(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getDeep(root.left), getDeep(root.right));
    }

    private static void getEdge(TreeNode[][] edge, TreeNode root, int i) {
        if (root == null) return;
        edge[i][0] = edge[i][0] == null ? root : edge[i][0];
        edge[i][1] = root;
        getEdge(edge, root.left, i + 1);
        getEdge(edge, root.right, i + 1);
    }

    private static void getLeaf(TreeNode root, int i, TreeNode[][] edge, StringBuilder builder) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root != edge[i][0] && root != edge[i][1]) {
                builder.append(root.val).append(" ");
            }
            return;
        }
        getLeaf(root.left, i + 1, edge, builder);
        getLeaf(root.right, i + 1, edge, builder);
    }

    public static void getBoundary2(TreeNode root, StringBuilder builder) {
        if (root == null) return;
        builder.append(root.val).append(" ");
        if (root.left != null && root.right != null) {
            printLeftEdge(root.left, true, builder);
            printRightEdge(root.right, true, builder);
        } else {
            getBoundary2(root.left != null ? root.left : root.right, builder);
        }
    }

    private static void printLeftEdge(TreeNode h, boolean print, StringBuilder builder) {
        if (h == null) return;
        if (print || (h.left == null && h.right == null)) {
            builder.append(h.val).append(" ");
        }
        printLeftEdge(h.left, print, builder);
        printLeftEdge(h.right, print && h.left == null, builder);
    }

    private static void printRightEdge(TreeNode h, boolean print, StringBuilder builder) {
        if (h == null) return;
        printRightEdge(h.left, print && h.right == null, builder);
        printRightEdge(h.right, print, builder);
        if (print || (h.left == null && h.right == null)) {
            builder.append(h.val).append(" ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] items = in.nextLine().split(" ");
        int n = Integer.parseInt(items[0]);
        TreeNode root = buildTree(n, in);
        System.out.println(getBoundary1(root));
        StringBuilder builder = new StringBuilder();
        getBoundary2(root, builder);
        System.out.println(builder.toString());
    }

}

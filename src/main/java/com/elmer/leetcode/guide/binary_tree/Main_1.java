package com.elmer.leetcode.guide.binary_tree;

import com.elmer.leetcode.common.TreeNode;

import static com.elmer.leetcode.common.BinaryTreeUtil.*;

import java.util.Scanner;

public class Main_1 {

    public static String getTravelResult(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        preOrder(root, builder);
        builder.append("\n");
        inOrder(root, builder);
        builder.append("\n");
        postOrder(root, builder);
        return builder.toString();
    }

    public static void preOrder(TreeNode root, StringBuilder builder) {
        if (root == null) return;
        builder.append(root.val).append(" ");
        preOrder(root.left, builder);
        preOrder(root.right, builder);
    }

    public static void inOrder(TreeNode root, StringBuilder builder) {
        if (root == null) return;
        inOrder(root.left, builder);
        builder.append(root.val).append(" ");
        inOrder(root.right, builder);
    }

    public static void postOrder(TreeNode root, StringBuilder builder) {
        if (root == null) return;
        postOrder(root.left, builder);
        postOrder(root.right, builder);
        builder.append(root.val).append(" ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] items = in.nextLine().split(" ");
        int n = Integer.parseInt(items[0]), val = Integer.parseInt(items[1]);
        TreeNode root = buildTree(n, in);
        System.out.println(getTravelResult(root));
    }

}

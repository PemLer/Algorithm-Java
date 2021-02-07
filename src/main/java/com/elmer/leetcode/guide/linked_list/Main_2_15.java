package com.elmer.leetcode.guide.linked_list;

import com.elmer.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.elmer.leetcode.common.BinaryTreeUtil.buildTree;

public class Main_2_15 {

    TreeNode pre = null, head = null;

    public TreeNode toDLinkedList(TreeNode root) {
        if (root == null) return null;
        travel(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void travel(TreeNode root) {
        if (root == null) return;
        travel(root.left);
        if (head == null) {
            head = root;
            pre = root;
        } else {
            root.left = pre;
            pre.right = root;
            pre = root;
        }
        travel(root.right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        TreeNode root = buildTree(n, in);
        Main_2_15 main = new Main_2_15();
        StringBuilder builder = new StringBuilder();
        root = main.toDLinkedList(root);
        if (root != null) {
            builder.append(root.val).append(" ");
            TreeNode cur = root.right;
            while (cur != root) {
                builder.append(cur.val).append(" ");
                cur = cur.right;
            }
        }
        System.out.println(builder.toString());
    }
}

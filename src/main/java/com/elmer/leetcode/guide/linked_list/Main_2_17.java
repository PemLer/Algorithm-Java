package com.elmer.leetcode.guide;

import com.elmer.leetcode.common.Node;

import java.util.Scanner;

public class Main_2_17 {

    public static void delete(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Node head = null, node = null, cur = null;
        String[] vals = in.nextLine().split(" ");
        int m = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(vals[i]);
            Node tmp = new Node(v);
            if (i + 1 == m) {
                node = tmp;
            }
            if (head == null) {
                head = tmp;
                cur = tmp;
            } else {
                cur.next = tmp;
                cur = cur.next;
            }
        }
        delete(node);
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val).append(" ");
            head = head.next;
        }
        System.out.println(builder.toString());
    }
}

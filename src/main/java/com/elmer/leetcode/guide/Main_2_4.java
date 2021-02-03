package com.elmer.leetcode.guide;


import com.elmer.leetcode.common.Node;

import java.util.Scanner;

class DNode {
    int val;
    DNode next;
    DNode pre;

    public DNode(int val) {
        this.val = val;
    }

}

public class Main_2_4 {

    public static Node reverse1(Node head) {
        if (head == null || head.next == null) return head;
        Node pre = null;
        while (head != null) {
            Node next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DNode reverse2(DNode head) {
        if (head == null || head.next == null) return head;
        DNode pre = null;
        while (head != null) {
            DNode next = head.next;
            head.next = pre;
            if (pre != null) {
                pre.pre = head;
            }
            pre = head;
            head = next;
        }
        pre.pre = null;
        return pre;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] vals = in.nextLine().split(" ");
        Node head1 = null, cur = null;
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(vals[i]);
            Node node = new Node(val);
            if (head1 == null) {
                head1 = node;
                cur = node;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }
        head1 = reverse1(head1);
        StringBuilder builder = new StringBuilder();
        while (head1 != null) {
            builder.append(head1.val).append(" ");
            head1 = head1.next;
        }
        builder.append("\n");

        int m = Integer.parseInt(in.nextLine());
        vals = in.nextLine().split(" ");
        DNode head2 = null, c = null;
        for (int i = 0; i < m; i++) {
            int val = Integer.parseInt(vals[i]);
            DNode node = new DNode(val);
            if (head2 == null) {
                head2 = node;
                c = node;
            } else {
                c.next = node;
                node.pre = c;
                c = c.next;
            }
        }
        head2 = reverse2(head2);
        while (head2 != null) {
            builder.append(head2.val).append(" ");
            head2 = head2.next;
        }
        System.out.println(builder.toString());
    }

}

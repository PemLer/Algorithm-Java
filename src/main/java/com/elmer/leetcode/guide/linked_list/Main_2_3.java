package com.elmer.leetcode.guide.linked_list;


import com.elmer.leetcode.common.Node;

import java.util.Scanner;

public class Main_2_3 {

    public static Node delete(Node head, int k) {
        if (head == null || k == 0) return head;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node first = dummy;
        while (k > 1 && dummy != null) {
            dummy = dummy.next;
            k--;
        }
        if (dummy == null || dummy.next == null) {
            return head;
        }
        dummy.next = dummy.next.next;
        return first.next;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] items = in.nextLine().split(" ");
        int n = Integer.parseInt(items[0]), m = Integer.parseInt(items[1]);
        Node head = null, cur = null;
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            Node node = new Node(val);
            if (head == null) {
                head = node;
                cur = node;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }
        head = delete(head, m);
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val).append(" ");
            head = head.next;
        }
        System.out.println(builder.toString());
    }

}

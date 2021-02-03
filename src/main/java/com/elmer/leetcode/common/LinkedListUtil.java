package com.elmer.leetcode.common;

import java.util.Scanner;

public class LinkedListUtil {

    public static Node getLinkedList(int n, Scanner in) {
        Node head = null, cur = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(in.nextInt());
            if (head == null) {
                head = node;
                cur = node;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }
        return head;
    }

    public static String linkedListToString(Node head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val).append(" ");
            head = head.next;
        }
        return builder.toString();
    }


}

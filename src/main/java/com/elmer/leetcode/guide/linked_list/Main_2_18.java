package com.elmer.leetcode.guide;

import com.elmer.leetcode.common.Node;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_2_18 {

    public static Node insert(Node head, int num) {
        Node node = new Node(num);
        if (head.next == head) {

        }
        Node last = null, cur = head;
        while (cur.next != head) {
            cur = cur.next;
        }
        last = cur;
        if (last.val <= num) {
            last.next = node;
            node.next = head;
            return head;
        }
        if (head.val >= num) {
            last.next = node;
            node.next = head;
            head = node;
            return head;
        }

        cur = head;
        while (cur.val < num) {
            cur = cur.next;
            last = last.next;
        }
        last.next = node;
        node.next = cur;
        return head;
    }

    private static Node getLinkedList(int n, Scanner in) {
        Node head = null, cur = null, node = null;
        for (int i = 0; i < n; i++) {
            node = new Node(in.nextInt());
            if (head == null) {
                head = node;
                cur = node;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }
        node.next = head;
        return head;
    }

    public static String linkedListToString(Node head) {
        StringBuilder builder = new StringBuilder();
        Set<Node> set = new HashSet<>();
        while (head != null && !set.contains(head)) {
            builder.append(head.val).append(" ");
            set.add(head);
            head = head.next;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Node head = getLinkedList(n, in);
        int num = Integer.parseInt(in.next());
        head = insert(head, num);
        System.out.println(linkedListToString(head));
    }

}

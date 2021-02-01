package com.elmer.leetcode.guide;

import java.util.Scanner;

public class Main_2_5 {

    public static Node reversePartial(Node head, int from, int to) {
        if (from >= to) return head;
        Node dummy = new Node(-1), first = dummy;
        dummy.next = head;
        int count = 0;
        Node preStop = null, postStop = null, reverseHead = null;

        while (head != null) {
            count++;
            if (count == from) {
                preStop = dummy;
                reverseHead = head;
                dummy = dummy.next;
                head = head.next;
                preStop.next = null;
                continue;
            }
            if (count == to) {
                postStop = head.next;
                head.next = null;
                break;
            }
            dummy = dummy.next;
            head = head.next;
        }
        Node[] nodes = reverse(reverseHead);
        preStop.next = nodes[0];
        nodes[1].next = postStop;
        return first.next;
    }

    private static Node[] reverse(Node head) {
        if (head == null || head.next == null) return new Node[]{head, head};
        Node pre = null, h = head;
        while (head != null) {
            Node next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return new Node[]{pre, h};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] vals = in.nextLine().split(" ");
        String[] items = in.nextLine().split(" ");
        int from = Integer.parseInt(items[0]), to = Integer.parseInt(items[1]);
        Node head = null, cur = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(Integer.parseInt(vals[i]));
            if (head == null) {
                head = node;
                cur = node;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }
        head = reversePartial(head, from, to);
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val).append(" ");
            head = head.next;
        }
        System.out.println(builder.toString());
    }

}

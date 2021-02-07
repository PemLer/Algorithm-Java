package com.elmer.leetcode.guide.linked_list;

import com.elmer.leetcode.common.Node;

import java.util.Scanner;

import static com.elmer.leetcode.common.LinkedListUtil.getLinkedList;

public class Main_2_8 {

    public static Node process(Node head, int target) {
        if (head == null || head.next == null) return head;
        Node less = new Node(-1), l = less;
        Node equal = new Node(-1), e = equal;
        Node bigger = new Node(-1), b = bigger;

        while (head != null) {
            int val = head.val;
            if (val < target) {
                l.next = head;
                l = l.next;
            } else if (val > target) {
                b.next = head;
                b = b.next;
            } else {
                e.next = head;
                e = e.next;
            }
            head = head.next;
        }

        l.next = null;
        e.next = null;
        b.next = null;

        e.next = bigger.next;
        l.next = equal.next;
        return less.next;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] items = in.nextLine().split(" ");
        int n = Integer.parseInt(items[0]), m = Integer.parseInt(items[1]);
        Node head = getLinkedList(n, in);
        head = process(head, m);
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val).append(' ');
            head = head.next;
        }
        System.out.println(builder.toString());
    }
}

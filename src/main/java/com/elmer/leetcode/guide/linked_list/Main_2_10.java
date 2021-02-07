package com.elmer.leetcode.guide.linked_list;

import com.elmer.leetcode.common.Node;

import java.util.Scanner;

import static com.elmer.leetcode.common.LinkedListUtil.getLinkedList;

public class Main_2_10 {

    public static Node add(Node p, Node q) {
        p = reverse(p);
        q = reverse(q);
        Node dummy = new Node(-1), cur = dummy;
        int carry = 0, c1, c2, val;
        while (p != null || q != null) {
            c1 = p != null ? p.val : 0;
            c2 = q != null ? q.val : 0;
            val = (c1 + c2 + carry) % 10;
            carry = (c1 + c2 + carry) / 10;
            cur.next = new Node(val);

            p = p != null ? p.next : null;
            q = q != null ? q.next : null;
            cur = cur.next;
        }
        if (carry != 0) {
            cur.next = new Node(carry);
        }
        return reverse(dummy.next);
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) return head;

        Node pre = null, next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] items = in.nextLine().split(" ");
        int n = Integer.parseInt(items[0]), m = Integer.parseInt(items[1]);
        Node p = getLinkedList(n, in);
        Node q = getLinkedList(m, in);
        Node head = add(p, q);
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val).append(" ");
            head = head.next;
        }
        System.out.println(builder.toString());
    }

}

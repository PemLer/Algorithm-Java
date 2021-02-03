package com.elmer.leetcode.guide;

import com.elmer.leetcode.common.Node;

import java.util.Scanner;

import static com.elmer.leetcode.common.LinkedListUtil.getLinkedList;
import static com.elmer.leetcode.common.LinkedListUtil.linkedListToString;

public class Main_2_19 {

    public static Node merge(Node p, Node q) {
        Node dummy = new Node(-1), cur = dummy;
        while (p != null || q != null) {
            if (p == null) {
                cur.next = q;
                break;
            } else if (q == null) {
                cur.next = p;
                break;
            } else {
                if (p.val < q.val) {
                    cur.next = p;
                    p = p.next;
                } else {
                    cur.next = q;
                    q = q.next;
                }
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Node p = getLinkedList(n, in);
        int m = Integer.parseInt(in.next());
        Node q = getLinkedList(m, in);
        Node head = merge(p, q);
        System.out.println(linkedListToString(head));
    }

}

package com.elmer.leetcode.guide;

import com.elmer.leetcode.common.Node;

import java.util.Scanner;

public class Main_2_2 {

    public static Node delete(Node head, int k) {
        if (head == null || k == 0) return head;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node first = dummy, second = dummy;
        for (int i = 0;i < k; i++) {
            first = first.next;
        }
        if (first.next == null) return head.next;

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return head;
    }

    /*
        4
        1 2 3 4 5
        -1 1 2 3 4 5

        [-1] 1 2 3 [4] 5
        -1 [1] 2 3 4 [5]
        -1 1 [2] 3 4 5 [null]
        
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] items = in.nextLine().split(" ");
        int n = Integer.parseInt(items[0]), k = Integer.parseInt(items[1]);
        Node head = null, cur = null;
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            Node new_node = new Node(val);
            if (head == null) {
                head = new_node;
                cur = new_node;
            } else {
                cur.next = new_node;
                cur = cur.next;
            }
        }
        head = delete(head, k);
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val).append(" ");
            head = head.next;
        }
        System.out.println(builder.toString());
    }
}

package com.elmer.leetcode.guide;

import com.elmer.leetcode.common.Node;
import static com.elmer.leetcode.common.LinkedListUtil.*;

import java.util.Scanner;

public class Main_2_20 {

    public static Node resign(Node head) {
        if (head == null || head.next == null) return head;
        Node dummy = new Node(-1), cur = dummy;
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node tmp = slow;
        while (slow != null && head != tmp) {
            cur.next = head;
            cur = cur.next;
            head = head.next;
            cur.next = slow;
            cur = cur.next;
            slow = slow.next;
        }
        if (slow != null) {
            cur.next = slow;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Node head = getLinkedList(n, in);
        head = resign(head);
        System.out.println(linkedListToString(head));
    }

}

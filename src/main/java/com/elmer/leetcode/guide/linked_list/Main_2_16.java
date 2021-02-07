package com.elmer.leetcode.guide;

import com.elmer.leetcode.common.Node;

import java.util.Scanner;

import static com.elmer.leetcode.common.LinkedListUtil.getLinkedList;
import static com.elmer.leetcode.common.LinkedListUtil.linkedListToString;

public class Main_2_16 {

    public static Node selectSort(Node head) {
        if (head == null || head.next == null) return head;

        Node dummy = new Node(-1);
        Node tail = dummy;
        Node preSmall = null, small = null;

        while (head != null) {
            preSmall = getMinNode(head);
            if (preSmall == null) {
                small = head;
                head = head.next;
            } else {
                small = preSmall.next;
                preSmall.next = preSmall.next.next;
            }
            tail.next = small;
            tail = tail.next;
        }
        return dummy.next;
    }

    private static Node getMinNode(Node head) {
        if (head == null) return null;
        Node preSmall = null;
        int min = head.val;
        while (head.next != null) {
            if (head.next.val < min) {
                min = head.next.val;
                preSmall = head;
            }
            head = head.next;
        }
        return preSmall;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Node head = getLinkedList(n, in);
        head = selectSort(head);
        System.out.println(linkedListToString(head));
    }

}

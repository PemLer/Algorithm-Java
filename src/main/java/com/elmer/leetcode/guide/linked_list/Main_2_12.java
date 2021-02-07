package com.elmer.leetcode.guide.linked_list;

import com.elmer.leetcode.common.Node;
import static com.elmer.leetcode.common.LinkedListUtil.*;

import java.util.Scanner;

public class Main_2_12 {

    public static Node reverseK(Node head, int k) {
        Node dummy = new Node(-1), next = null, p, first = dummy;
        dummy.next = head;
        int count = 0;
        while (head != null) {
            count++;
            if (count % k == 0) {
                next = head.next;
                head.next = null;
                p = reverse(dummy.next);
                Node tmp = dummy.next;
                dummy.next.next = next;
                dummy.next = p;
                dummy = tmp;
                head = next;
            } else {
                head = head.next;
            }
        }
        return first.next;
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node next = null, pre = null;
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
        int n = Integer.parseInt(in.nextLine());
        Node head = getLinkedList(n, in);
        int k = Integer.parseInt(in.next());
        head = reverseK(head, k);
        System.out.println(linkedListToString(head));
    }

}

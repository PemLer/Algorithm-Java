package com.elmer.leetcode.guide.linked_list;

import com.elmer.leetcode.common.Node;

import java.util.Scanner;

import static com.elmer.leetcode.common.LinkedListUtil.getLinkedList;
import static com.elmer.leetcode.common.LinkedListUtil.linkedListToString;

public class Main_2_14 {

    public static Node delete(Node head, int num) {
        Node dummy = new Node(-1), cur = dummy;
        dummy.next = head;

        while (head != null) {
            if (head.val == num) {
                head = head.next;
                cur.next = head;
            } else {
                head = head.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Node head = getLinkedList(n, in);
        int num = Integer.parseInt(in.next());
        head = delete(head, num);
        System.out.println(linkedListToString(head));
    }

}

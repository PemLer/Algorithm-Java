package com.elmer.leetcode.guide.linked_list;

import com.elmer.leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.elmer.leetcode.common.LinkedListUtil.getLinkedList;

public class Main_2_7 {

    public static boolean isTrue(Node head) {
        if (head == null || head.next == null) return true;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int i = 0, j = list.size() - 1;
        boolean res = true;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                res = false;
                break;
            }
            i++;
            j--;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Node head = getLinkedList(n, in);
        System.out.println(isTrue(head));
    }
}

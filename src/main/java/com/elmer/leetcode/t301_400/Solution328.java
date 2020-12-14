package com.elmer.leetcode.t301_400;

import com.elmer.leetcode.common.ListNode;

public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode headOdd = new ListNode(-1);
        ListNode headEven = new ListNode(-1);
        ListNode curOdd = headOdd, curEven = headEven;
        int i = 0;
        while (head != null) {
            i++;
            if (i % 2 == 1) {
                curOdd.next = head;
                curOdd = curOdd.next;
            } else {
                curEven.next = head;
                curEven = curEven.next;
            }
            head = head.next;
        }
        curOdd.next = headEven.next;
        curEven.next = null;
        return headOdd.next;
    }
}

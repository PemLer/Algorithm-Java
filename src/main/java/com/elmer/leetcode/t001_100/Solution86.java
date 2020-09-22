package com.elmer.leetcode.t001_100;

import com.elmer.leetcode.common.ListNode;

public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1), s = small;
        ListNode big = new ListNode(-1), b = big;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        small.next = b.next;
        big.next = null;  // 重要，不然有环
        return s.next;
    }
}

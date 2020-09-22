package com.elmer.leetcode.t001_100;

import com.elmer.leetcode.common.ListNode;

public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }
        if (n == 0 || k % n == 0) return head;

        k %= n;
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        p = slow.next;
        slow.next = null;
        fast.next = head;
        return p;
    }
}

package com.elmer.leetcode.t201_300;

import com.elmer.leetcode.common.ListNode;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

package com.elmer.leetcode.t001_100;

import com.elmer.leetcode.common.ListNode;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode cur = dummy;
        cur.next = head;
        while (head != null) {
            if (head.next == null || head.next.val != head.val) {
                cur = cur.next;
                head = head.next;
            } else {
                head.next = head.next.next;
            }
        }
        return dummy.next;
    }
}

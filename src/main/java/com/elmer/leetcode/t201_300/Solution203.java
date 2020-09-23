package com.elmer.leetcode.t201_300;

import com.elmer.leetcode.common.ListNode;

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        cur.next = head;
        while (head != null) {
            if (head.val == val) {
                dummy.next = head.next;
                head = head.next;
            } else {
                dummy = dummy.next;
                head = head.next;
            }
        }
        return cur.next;
    }
}

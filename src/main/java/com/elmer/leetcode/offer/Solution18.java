package com.elmer.leetcode.offer;

import com.elmer.leetcode.common.ListNode;

public class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        cur.next = head;
        while (head != null) {
            if (head.val == val) {
                cur.next = head.next;
                head = head.next;
                break;
            } else {
                head = head.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

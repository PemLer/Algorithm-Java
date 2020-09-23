package com.elmer.leetcode.t001_100;

import com.elmer.leetcode.common.ListNode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int idx = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        cur.next = head;
        while (head != null && head.next != null) {
            idx++;
            if (idx < m) {
                dummy = dummy.next;
                head = head.next;
            } else if (idx >= m && idx < n) {
                ListNode tmp = head.next;
                ListNode next = dummy.next;
                dummy.next = tmp;
                head.next = tmp.next;
                tmp.next = next;
            } else break;
        }
        return cur.next;
    }
}

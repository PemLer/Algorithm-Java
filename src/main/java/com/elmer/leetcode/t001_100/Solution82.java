package com.elmer.leetcode.t001_100;

import com.elmer.leetcode.common.ListNode;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode cur = dummy;
        cur.next = head;
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                cur = head;
                head = head.next;
            } else {
                int val = head.val;
                head = head.next;
                while (head.val == val) {
                    head = head.next;
                    if (head == null) break;
                }
                cur.next = head;
            }
        }
        return dummy.next;
    }
}

package com.elmer.leetcode.t001_100;

import com.elmer.leetcode.common.ListNode;

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode first = dummy;
        while (l1 != null && l2 != null) {
            int t = l1.val + l2.val + carry;
            carry = t / 10;
            dummy.next = new ListNode(t % 10);
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode l = null;
        if (l1 != null) {
            l = l1;
        } else if (l2 != null) {
            l = l2;
        }

        while (l != null) {
            int t = l.val + carry;
            carry = t / 10;
            dummy.next = new ListNode(t % 10);
            dummy = dummy.next;
            l = l.next;
        }

        if (carry != 0) {
            dummy.next = new ListNode(carry);
        }

        return first.next;
    }

}

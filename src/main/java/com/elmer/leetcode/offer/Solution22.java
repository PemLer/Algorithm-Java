package com.elmer.leetcode.offer;

import com.elmer.leetcode.common.ListNode;

public class Solution22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        ListNode second = head;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}

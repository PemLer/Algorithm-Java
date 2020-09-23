package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.ListNode;

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        int c = 0;
        boolean f = false;
        while (p != null || q != null) {
            if (p == null) {
                c++;
                f = true;
                q = q.next;
            } else if (q == null) {
                c++;
                p = p.next;
            }
            else {
                p = p.next;
                q = q.next;
            }
        }
        if (f) {
            p = headB;
            q = headA;
        } else {
            p = headA;
            q = headB;
        }
        for (int i = 0; i < c; i++) {
            p = p.next;
        }
        while (p != null) {
            if (p == q) return p;
            p = p.next;
            q = q.next;
        }
        return null;
    }
}

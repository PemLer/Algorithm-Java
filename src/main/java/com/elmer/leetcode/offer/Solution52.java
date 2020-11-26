package com.elmer.leetcode.offer;

import com.elmer.leetcode.common.ListNode;

public class Solution52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != null && B != null) {
            A = A.next;
            B = B.next;
        }
        ListNode fa = headA, fb = headB;
        while (A != null) {
            fa = fa.next;
            A = A.next;
        }
        while (B != null) {
            fb = fb.next;
            B = B.next;
        }

        while (fa != null && !fa.equals(fb)) {
            fa = fa.next;
            fb = fb.next;
        }
        return fa;
    }
}

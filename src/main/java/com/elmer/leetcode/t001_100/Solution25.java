package com.elmer.leetcode.t001_100;

import com.elmer.leetcode.common.ListNode;

import static com.elmer.leetcode.common.ListNode.toArrayList;

public class Solution25 {

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode dummy = new ListNode(-1), next;
        dummy.next = head;
        while (dummy.next != tail) {
            next = head.next;
            head.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return new ListNode[]{tail, head};
    }

    private ListNode[] reverse1(ListNode head, ListNode tail) {
        ListNode pre = new ListNode(-1), next, tailNext = tail.next;
        pre.next = head;
        while (head != tailNext) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = null;
        return new ListNode[]{tail, head};
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1), pre = dummy, tail, nxt;
        dummy.next = head;

        while (head != null) {
            tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            nxt = tail.next;
            ListNode[] nodes = reverse1(head, tail);
            pre.next = nodes[0];
            nodes[1].next = nxt;
            pre = nodes[1];
            head = nxt;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode
                l1 = new ListNode(1),
                l2 = new ListNode(2),
                l3 = new ListNode(3),
                l4 = new ListNode(4),
                l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution25 sol = new Solution25();
        ListNode p = sol.reverseKGroup(l1, 2);
        System.out.println(toArrayList(p));
    }
}

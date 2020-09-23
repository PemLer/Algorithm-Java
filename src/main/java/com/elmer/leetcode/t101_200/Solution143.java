package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution143 {
    // 空间复杂度要求O(1)
    // 先找到中点，然后翻转后半段，再拼装。
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = reverse(slow.next);
        slow.next = null;
        while (secondHead != null) {
            ListNode t = head.next;
            head.next = secondHead;
            secondHead = secondHead.next;
            head.next.next = t;
            head = t;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode root = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return root;
    }
}

package com.elmer.leetcode.t201_300;

import com.elmer.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution234 {
    // O(n) O(n)
//    public boolean isPalindrome(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//        int n = list.size() - 1;
//        for (int i = 0; i < (n + 1) / 2; i++) {
//            if (!list.get(i).equals(list.get(n - i))) return false;
//        }
//        return true;
//    }

    // O(n) O(1)
    public boolean isPalindrome(ListNode head) {
        /**
         * 1 找到中间节点
         * 2 翻转后半部分
         * 3 比较
         * 4 复原
         */
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy, mid;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reserve(slow.next);
        mid = slow.next;

        while (head != null && mid != null) {
            if (head.val != mid.val) {
                reserve(slow.next);
                return false;
            }
            head = head.next;
            mid = mid.next;
        }
        reserve(slow.next);
        return true;
    }

    private ListNode reserve(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur, pre = null;
        while (head != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }
}

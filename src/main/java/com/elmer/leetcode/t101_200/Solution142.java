package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.ListNode;

public class Solution142 {

//    // 方法一 HashSet
//    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        while (head != null) {
//            if (set.contains(head)) return head;
//            set.add(head);
//            head = head.next;
//        }
//        return null;
//    }

    // 方法二 快慢指针
    // 2*(L + B) = L + B + C + B => L = C
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != null) {
                    if (head == slow) return slow;
                    head = head.next;
                    slow = slow.next;
                }
            }
        }
        return null;
    }

}

package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.ListNode;

public class Solution148 {

//    // 方法一 递归
//    // 时间 O(nlogn) 空间 O(n) 递归调用栈空间
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode slow = head, fast = head;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        ListNode tmp = slow.next;
//        slow.next = null;
//        ListNode left = sortList(head);
//        ListNode right = sortList(tmp);
//        return mergeSort(left, right);
//    }
//
//    private ListNode mergeSort(ListNode left, ListNode right) {
//        ListNode dummy = new ListNode(-1);
//        ListNode cur = dummy;
//        while (left != null && right != null) {
//            if (left.val < right.val) {
//                cur.next = left;
//                left = left.next;
//            } else {
//                cur.next = right;
//                right = right.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = left == null ? right : left;
//        return dummy.next;
//    }

    // 方法二 迭代 自底向上
    // 时间 O(nlogn) 空间 O(1)
    // step=1: (3->4)->(1->7)->(8->9)->(2->11)->(5->6)
    // step=2: (1->3->4->7)->(2->8->9->11)->(5->6)
    // step=4: (1->2->3->4->7->8->9->11)->5->6
    // step=8: (1->2->3->4->5->6->7->8->9->11)
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 统计链表长度
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            ++n;
        }
        // 控制step一组
        for (int step = 1; step < n; step <<= 1) {
            // 一次完了归置cur和tail
            ListNode cur = dummy.next;
            ListNode tail = dummy;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = cut(cur, step);
                cur = cut(right, step);
                tail.next = merge(left, right);
                while (tail.next != null) tail = tail.next;  // 保持 tail 为尾部
            }
        }
        return dummy.next;
    }

    // 切除前n个节点，返回后半部分的头节点
    private ListNode cut(ListNode node, int step) {
        for (int i = 0; i < step - 1 && node != null; i++) {
            node = node.next;
        }
        if (node == null) return null;
        ListNode p = node.next;
        node.next = null;
        return p;
    }

    // 双路归并
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return dummy.next;
    }
}

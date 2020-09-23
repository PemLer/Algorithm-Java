package com.elmer.leetcode.t101_200;

import com.elmer.leetcode.common.ListNode;

public class Solution147 {
    // 链表插入排序
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        int max = head.val;
        ListNode cur = head.next;
        ListNode tail = head;  // 重要：记录前面有序部分的末尾节点
        while (cur != null) {
            if (cur.val >= max) {
                max = cur.val;
                cur = cur.next;
                tail = tail.next;
            } else {
                ListNode p = dummy;
                while (p.next.val <= cur.val) {
                    p = p.next;
                }
                ListNode t = p.next;
                p.next = cur;
                cur = cur.next;
                p.next.next = t;
                tail.next = cur;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,1,3};
        ListNode head = ListNode.creatListNode(nums);
        Solution147 sol = new Solution147();
        sol.insertionSortList(head);
    }
}

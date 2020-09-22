package com.elmer.leetcode.t001_100;

import com.elmer.leetcode.common.ListNode;

public class Solution24 {

//    // 方法一 迭代
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode dummy = new ListNode(-1);
//        ListNode cur = dummy;
//        dummy.next = head;
//        ListNode slow = head, fast = head.next;
//        while (fast != null) {
//            slow.next = fast.next;
//            dummy.next = fast;
//            fast.next = slow;
//            dummy = slow;
//            if (slow.next == null || slow.next.next == null) break;
//            slow = slow.next;
//            fast = slow.next;
//        }
//        return cur.next;
//    }

    // 方法二 递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head.next;

        slow.next = swapPairs(fast.next);
        fast.next = slow;

        return fast;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        ListNode root = ListNode.creatListNode(nums);
        Solution24 sol = new Solution24();
        sol.swapPairs(root);
    }
}

package com.elmer.leetcode.offer;

import com.elmer.leetcode.common.ListNode;

public class Solution24 {

//    // 方法一 从前往后移动每个节点
//    public ListNode reverseList(ListNode head) {
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//
//        while (head != null && head.next != null) {
//            ListNode tmp = head.next;
//            ListNode next = dummy.next;
//            dummy.next = tmp;
//            head.next = tmp.next;
//            tmp.next = next;
//        }
//        return dummy.next;
//    }

//    // 方法二 递归
//    /*
//    1 -> 2 -> 3 -> 4
//    1 -> 2    3 <- 4
//    1    2 <- 3 <- 4
//    1 <- 2 <- 3 <- 4
//     */
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode p = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return p;
//    }

    // 方法三 双指针修改指向关系
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, cur = head;
        ListNode tmp;
        while (cur != null) {
            tmp = cur;
            cur = cur.next;
            tmp.next = pre;
            pre = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode root = ListNode.creatListNode();
        System.out.println(ListNode.toArrayList(root));
        Solution24 sol = new Solution24();
        root = sol.reverseList(root);
        System.out.println(ListNode.toArrayList(root));
    }
}

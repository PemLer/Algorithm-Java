package com.elmer.leetcode.t001_100;

import com.elmer.leetcode.common.ListNode;

import java.util.PriorityQueue;

public class Solution23 {

//        // 方法一 分治
//    public ListNode mergeKLists(ListNode[] lists) {
//        return merge(lists, 0, lists.length - 1);
//    }
//
//    private ListNode merge(ListNode[] lists, int i, int j) {
//        if (i > j) return null;
//        else if (i == j) return lists[i];
//        int mid = (i + j) >> 1;
//        ListNode left = merge(lists, i, mid);
//        ListNode right = merge(lists, mid + 1, j);
//        return mergeSort(left, right);
//    }
//
//    private ListNode mergeSort(ListNode node1, ListNode node2) {
//        ListNode dummy = new ListNode(-1);
//        ListNode first = dummy;
//        while (node1 != null && node2 != null) {
//            if (node1.val < node2.val) {
//                first.next = node1;
//                node1 = node1.next;
//            } else {
//                first.next = node2;
//                node2 = node2.next;
//            }
//            first = first.next;
//        }
//        first.next = node1 != null ? node1 : node2;
//        return dummy.next;
//    }

    // 优先队列
    class Status implements Comparable<Status> {
        int val;
        ListNode node;
        Status(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        public int compareTo(Status status) {
            return this.val - status.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<>();
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(new Status(lists[i].val, lists[i]));
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll().node;
            cur.next = node;
            cur = cur.next;
            if (node.next != null) queue.add(new Status(node.next.val, node.next));
        }
        return dummy.next;
    }

}

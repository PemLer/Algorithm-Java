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

    // 方法二 优先队列
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1), cur = dummy, node;

        while (!heap.isEmpty()) {
            node = heap.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                heap.add(node.next);
            }
        }
        return dummy.next;
    }

}

package com.elmer.leetcode.t201_300;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution239 {

    // 方法一 优先队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[n - k + 1];
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> y[0] - x[0]);

        for (int i = 0; i < n; i++) {
            heap.add(new int[]{nums[i], i});
            if (i >= k - 1) {
                while (heap.peek()[1] <= (i - k)) {
                    heap.poll();
                }
                res[i - k + 1] = heap.peek()[0];
            }
        }

        return res;

    }

    // 方法二 单调队列
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        Deque<Integer> deque = new LinkedList<>();
//        int n = nums.length;
//        int[] res = new int[n - k + 1];
//        for (int i = 0; i < k; i++) {
//            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
//                deque.pollLast();
//            }
//            deque.addLast(nums[i]);
//        }
//        res[0] = deque.peekFirst();
//
//        for (int i = k; i < n; i++) {
//            if (!deque.isEmpty() && deque.peekFirst() == nums[i - k]) {
//                deque.pollFirst();
//            }
//            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
//                deque.pollLast();
//            }
//            deque.addLast(nums[i]);
//            res[i - k + 1] = deque.peekFirst();
//        }
//        return res;
//    }
}

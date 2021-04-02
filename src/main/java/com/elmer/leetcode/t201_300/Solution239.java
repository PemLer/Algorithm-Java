package com.elmer.leetcode.t201_300;

import java.util.Deque;
import java.util.LinkedList;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();

        for (int i = k; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}

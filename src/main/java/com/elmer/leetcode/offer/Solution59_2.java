package com.elmer.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution59_2 {
    class MaxQueue {

        Queue<Integer> queue;
        Deque<Integer> maxDeque;
        public MaxQueue() {
            queue = new LinkedList<>();
            maxDeque = new LinkedList<>();
        }

        public int max_value() {
            if (maxDeque.isEmpty()) return -1;
            return maxDeque.getFirst();
        }

        public void push_back(int value) {
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < value) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(value);
            queue.add(value);
        }

        public int pop_front() {
            if (!maxDeque.isEmpty() && maxDeque.getFirst().equals(queue.peek())) {
                maxDeque.pollFirst();
            }
            if (queue.isEmpty()) return -1;
            return queue.poll();
        }
    }

}

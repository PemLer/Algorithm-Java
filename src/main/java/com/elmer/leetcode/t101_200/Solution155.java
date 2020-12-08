package com.elmer.leetcode.t101_200;

import java.util.Stack;

public class Solution155 {

    class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.add(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.add(x);
            }
        }

        public void pop() {
            int val = stack.pop();
            if (val == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}

package com.elmer.leetcode.offer;

import java.util.LinkedList;
import java.util.Stack;

public class Solution30 {
    class MinStack {

        LinkedList<Integer> stack, minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.addLast(x);
            if (minStack.isEmpty() || x <= minStack.getLast()) {
                minStack.addLast(x);
            }
        }

        public void pop() {
            if (stack.getLast().equals(minStack.getLast())) {
                minStack.pollLast();
            }
            stack.pollLast();
        }

        public int top() {
            return stack.peekLast();
        }

        public int min() {
            return minStack.peekLast();
        }
    }

}

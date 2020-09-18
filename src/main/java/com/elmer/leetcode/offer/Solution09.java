package com.elmer.leetcode.offer;

import java.util.Stack;

public class Solution09 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Solution09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (!stack2.empty()) {
            return stack2.pop();
        }
        while (!stack1.empty()) {
            stack2.add(stack1.pop());
        }
        if (!stack2.empty()) {
            return stack2.pop();
        }
        return -1;
    }

}

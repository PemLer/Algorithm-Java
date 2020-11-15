package com.elmer.leetcode.offer;

import java.util.Stack;

public class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int cur = 0;
        Stack<Integer> stack = new Stack<>();
        for (int value : pushed) {
            stack.add(value);
            while (!stack.isEmpty() && stack.peek() == popped[cur]) {
                stack.pop();
                cur++;
            }
        }
        return stack.isEmpty();
    }
}

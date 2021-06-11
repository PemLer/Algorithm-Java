package com.elmer.leetcode.t101_200;

import java.util.Deque;
import java.util.LinkedList;

public class Solution150 {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (!isOpt(token)) {
                stack.addLast(Integer.parseInt(token));
            } else {
                int val2 = stack.pollLast();
                int val1 = stack.pollLast();
                stack.addLast(opt(token, val1, val2));
            }
        }
        return stack.pollLast();
    }

    private int opt(String token, int val1, int val2) {
        switch (token) {
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
            case "/":
                return val1 / val2;
            case "*":
                return val1 * val2;
            default:
                return 0;
        }
    }

    private boolean isOpt(String s) {
        return "+".equals(s) || "-".equals(s) || "/".equals(s) || "*".equals(s);
    }
}

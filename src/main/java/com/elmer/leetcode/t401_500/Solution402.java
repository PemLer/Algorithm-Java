package com.elmer.leetcode.t401_500;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !deque.isEmpty() && num.charAt(i) < deque.peekLast()) {
                deque.pollLast();
                k--;
            }
            deque.addLast(num.charAt(i));
        }
        while (k > 0) {
            deque.pollLast();
            k--;
        }
        while (!deque.isEmpty() && deque.peekFirst() == '0') {
            deque.pollFirst();
        }
        if (deque.isEmpty()) return "0";
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append(deque.pollFirst());
        }
        return builder.toString();
    }
}

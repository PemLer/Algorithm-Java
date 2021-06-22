package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Guide013 {

    private static void solve(Deque<Integer> stack) {
        // 1 3 100 5 4
        // 4 5 100 -> 1 100 5 4
        Deque<Integer> helper = new LinkedList<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!helper.isEmpty() && helper.peek() > cur) {
                stack.push(helper.pop());
            }
            helper.push(cur);
        }
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }
        solve(stack);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst()).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}

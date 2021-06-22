package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Guide007 {

    public static int getAndRemoveLastElement(Deque<Integer> stack) {
        int res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(res);
            return last;
        }
    }

    public static void reverse(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }
        reverse(stack);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}

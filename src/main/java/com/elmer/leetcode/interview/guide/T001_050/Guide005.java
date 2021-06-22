package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Guide005 {

    static Deque<Integer> stack = new LinkedList<>();
    static Deque<Integer> minStack = new LinkedList<>();

    private static void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    private static void pop() {
        int val = stack.pop();
        if (minStack.peek() == val) {
            minStack.pop();
        }
    }

    private static void getMin() {
        System.out.println(minStack.peek());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.startsWith("push")) {
                int val = Integer.parseInt(line.split(" ")[1]);
                push(val);
            } else if (line.equals("pop")) {
                pop();
            } else {
                getMin();
            }
        }
    }
}

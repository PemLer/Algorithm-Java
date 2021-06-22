package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Guide006 {

    static Deque<Integer> stack1 = new LinkedList<>();
    static Deque<Integer> stack2 = new LinkedList<>();

    private static void add(int val) {
        stack1.push(val);
    }

    private static void poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }

    private static void peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        System.out.println(stack2.peek());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.startsWith("add")) {
                int val = Integer.parseInt(line.split(" ")[1]);
                add(val);
            } else if (line.equals("poll")) {
                poll();
            } else {
                peek();
            }
        }
    }
}

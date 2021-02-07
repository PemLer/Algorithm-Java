package com.elmer.leetcode.guide.stack_and_queue;

import java.util.Scanner;
import java.util.Stack;

public class Main_1_2 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Main_1_2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int value) {
        stack1.push(value);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        Main_1_2 main = new Main_1_2();
        Scanner in = new Scanner(System.in);
        int lineNum = Integer.parseInt(in.nextLine());
        for (int i = 0; i < lineNum; i++) {
            String line = in.nextLine();
            if (line.startsWith("add")) {
                int val = Integer.parseInt(line.split(" ")[1]);
                main.push(val);
            } else if (line.equals("poll")) {
                main.pop();
            } else if (line.equals("peek")) {
                System.out.println(main.peek());
            }
        }
    }
}

package com.elmer.leetcode.guide.stack_and_queue;

import java.util.Scanner;
import java.util.Stack;

public class Main_1_3 {

    Stack<Integer> stack;

    public Main_1_3() {
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
    }

    public int getAndRemoveLastElement() {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement();
            stack.push(result);
            return last;
        }
    }

    public void reverse() {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement();
        reverse();
        stack.push(i);
    }

    public void print() {
        Stack<Integer> stack1 = new Stack<>();
        while (!stack.isEmpty()) {
            stack1.add(stack.pop());
        }
        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop() + " ");
        }
    }


    public static void main(String[] args) {
        Main_1_3 main = new Main_1_3();
        Scanner scanner = new Scanner(System.in);
        int lineNum = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lineNum; i++) {
            int val = scanner.nextInt();
            main.push(val);
        }
        main.reverse();
        main.print();
    }
}

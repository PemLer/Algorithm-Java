package com.elmer.leetcode.guide;

import java.util.Scanner;
import java.util.Stack;

public class Main_1_1 {

    Stack<Integer> stack1;
    Stack<Integer> stackMin;

    public Main_1_1() {
        stack1 = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int val) {
        if (stackMin.isEmpty() || stackMin.peek() >= val) {
            stackMin.push(val);
        }
        stack1.push(val);
    }

    public int pop() {
        int val = stack1.pop();
        if (!stackMin.isEmpty() && stackMin.peek() == val) {
            stackMin.pop();
        }
        return val;
    }

    public int getMin() {
        return stackMin.peek();
    }


    public static void main(String[] args) {
        Main_1_1 main = new Main_1_1();

        Scanner in = new Scanner(System.in);
        int lineNum = Integer.parseInt(in.nextLine());
        for (int i = 0; i < lineNum; i++) {
            String str = in.nextLine();
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                main.push(val);
            } else if (str.equals("pop")) {
                main.pop();
            } else {
                System.out.println(main.getMin());
            }
        }
    }
}
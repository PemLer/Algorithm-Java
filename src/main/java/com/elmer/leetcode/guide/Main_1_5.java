package com.elmer.leetcode.guide;

import java.util.Scanner;
import java.util.Stack;

public class Main_1_5 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Main_1_5() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void add(int val) {
        stack1.add(val);
    }

    public void sort() {
        while (!stack1.isEmpty()) {
            int val = stack1.pop();
            while (!stack2.isEmpty() && stack2.peek() > val) {
                stack1.add(stack2.pop());
            }
            stack2.add(val);
        }
    }

    public void print() {
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Main_1_5 main = new Main_1_5();
        Scanner in = new Scanner(System.in);
        int numLine = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numLine; i++) {
            int val = in.nextInt();
            main.add(val);
        }
        main.sort();
        main.print();
    }

}

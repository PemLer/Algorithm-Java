package com.elmer.leetcode.t201_300;

import java.util.Stack;

public class Solution227 {

    Stack<Integer> nums;
    Stack<Character> operators;
    int res;
    public int calculate(String s) {
        nums = new Stack<>();
        operators = new Stack<>();
        res = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (c >= '0' && c <= '9') {
                int num = 0;
                while (c >= '0' && c <= '9') {
                    num = num * 10 + (c - '0');
                    i++;
                    if (i == s.length()) break;
                    c = s.charAt(i);
                }
                nums.add(num);
            } else if (c == '+' || c == '-') {
                while (!operators.isEmpty()) {
                    calOnce();
                }
                operators.add(c);
                i++;
            } else if (c == '*' || c == '/') {
                if (!operators.isEmpty() && operators.peek() != '+' && operators.peek() != '-') {
                    calOnce();
                }
                operators.add(c);
                i++;
            }
        }
        while (!operators.isEmpty()) {
            calOnce();
        }
        return nums.pop();
    }

    private void calOnce() {
        char operator = operators.pop();
        int num1 = nums.pop(), num2 = nums.pop();
        switch (operator) {
            case '-':
                nums.add(num2 - num1);
                break;
            case '+':
                nums.add(num1 + num2);
                break;
            case '*':
                nums.add(num1 * num2);
                break;
            case '/':
                nums.add(num2 / num1);
                break;
        }
    }
}

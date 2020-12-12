package com.elmer.leetcode.t801_;

import java.util.Stack;

public class Solution962 {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.length;
        // 得到A的单调递减栈
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.add(i);
            }
        }
        int res = 0, i = n - 1;
        while (i > res) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                res = Math.max(res, i - stack.pop());
            }
            i--;
        }
        return res;
    }
}

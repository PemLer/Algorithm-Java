package com.elmer.leetcode.t801_;

import java.util.Stack;

public class Solution1124 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        // 大于8编码为1，小于8编码为-1
        int[] hourCode = new int[n];
        for (int i = 0; i < n; i++) {
            hourCode[i] = hours[i] > 8 ? 1 : -1;
        }
        // 求编码的前缀和
        int[] preSum = new int[n + 1];
        int total = 0;
        for (int i = 0; i < n; i++) {
            preSum[i] = total;
            total += hourCode[i];
        }
        preSum[n] = total;
        // 单调递减栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n + 1; i++) {
            if (stack.isEmpty() || preSum[stack.peek()] > preSum[i]) {
                stack.add(i);
            }
        }
        // 求最长坡度，倒序遍历
        int res = 0;
        for (int i = n; i >= 0; i--) {
            while (!stack.isEmpty() && preSum[stack.peek()] < preSum[i]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }
}

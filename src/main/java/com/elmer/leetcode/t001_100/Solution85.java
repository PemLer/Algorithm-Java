package com.elmer.leetcode.t001_100;

import java.util.Stack;

public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j] = matrix[i][j] == '0' ? 0 : dp[j] + 1;
            }
            res = Math.max(res, getMax(dp));
        }
        return res;
    }

    private int getMax(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int res = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && arr[stack.peek()] > arr[i]) {
                int index = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * arr[index]);
            }
            stack.add(i);
        }
        while (stack.peek() != -1) {
            int index = stack.pop();
            res = Math.max(res, (n - stack.peek() - 1) * arr[index]);
        }
        return res;
    }
}

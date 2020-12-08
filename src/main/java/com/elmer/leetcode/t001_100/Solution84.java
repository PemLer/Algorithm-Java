package com.elmer.leetcode.t001_100;

import java.util.Stack;

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int n = heights.length, ans = 0;
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int top = stack.pop();
                ans = Math.max(ans, (i - stack.peek() - 1) * heights[top]);  // 两边低乘以中间高
            }
            stack.add(i);
        }
        while (stack.peek() != -1) {
            int top = stack.pop();
            ans = Math.max(ans, (n - stack.peek() - 1) * heights[top]);
        }
        return ans;
    }
}

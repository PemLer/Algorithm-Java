package com.elmer.leetcode.offer;

import java.util.Stack;

public class Solution63 {
//    public int maxProfit(int[] prices) {
//        int n = prices.length;
//        if (n == 0) return 0;
//        int min_price = prices[0], ans = 0;
//        for (int i = 1; i < n; i++) {
//            if (prices[i] < min_price) {
//                min_price = prices[i];
//            } else {
//                ans = Math.max(ans, prices[i] - min_price);
//            }
//        }
//        return ans;
//    }

    // 单调栈
    public int maxProfit(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (!stack.isEmpty() && prices[i] > stack.peek()) {
                ans = Math.max(ans, prices[i] - stack.peek());
            } else {
                stack.add(prices[i]);
            }
        }
        return ans;
    }
}

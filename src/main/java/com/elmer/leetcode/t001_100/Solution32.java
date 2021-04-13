package com.elmer.leetcode.t001_100;

import java.util.Deque;
import java.util.LinkedList;

public class Solution32 {

    // 方法一 DP
    public int longestValidParentheses(String s) {
        // s[i] = ")"
        //    s[i-1] = "("  dp[i] = dp[i-2] + 2
        //    s[i-1] = ")"
        //        if s[i - 1 - dp[i-1]] = "(": dp[i] = dp[i-1] + 2 + dp[i - 1 - dp[i-1] - 1]
        int n = s.length(), res = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                dp[i] = 0;
            } else {
                if (i > 0 && s.charAt(i-1) == '(') {
                    if (i > 1) {
                        dp[i] = dp[i-2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else if (i > 0 && s.charAt(i-1) == ')') {
                    if (i - 1 - dp[i-1] >= 0 && s.charAt(i - 1 - dp[i-1]) == '(') {
                        if (i - 1 - dp[i-1] - 1 >= 0) {
                            dp[i] = dp[i-1] + 2 + dp[i - 1 - dp[i-1] - 1];
                        } else {
                            dp[i] = dp[i-1] + 2;
                        }
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 方法二 栈
    public int longestValidParentheses2(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(-1);

        int n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.addLast(i);
            } else {
                if (stack.peekLast() != -1 && s.charAt(stack.peekLast()) == '(') {
                    int index = stack.pollLast();
                    res = Math.max(res, i - stack.peekLast());
                } else {
                    stack.addLast(i);
                }
            }
        }

        return res;

    }
}

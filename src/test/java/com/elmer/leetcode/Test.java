package com.elmer.leetcode;

import com.elmer.leetcode.common.ListNode;
import com.elmer.leetcode.common.TreeNode;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        return;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length, profit = 0;
        if (n <= 1) {
            return profit;
        }
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}

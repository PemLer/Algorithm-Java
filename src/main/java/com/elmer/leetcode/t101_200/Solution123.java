package com.elmer.leetcode.t101_200;

public class Solution123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] record = new int[n];

        int profit = 0, min = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            profit = Math.max(profit, prices[i] - min);
            record[i] = profit;
        }

        int max = prices[n - 1], res = record[n - 1];
        for (int i = n - 2; i > 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            }
            res = Math.max(res, record[i-1] + max - prices[i]);
        }
        return res;
    }
}

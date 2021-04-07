package com.elmer.leetcode.t101_200;

public class Solution122 {
    public int maxProfit(int[] prices) {
        int n = prices.length, profit = 0;
        if (n <= 1) {
            return profit;
        }
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i-1]) {
                profit += (prices[i] - prices[i-1]);
            }
        }
        return profit;
    }
}

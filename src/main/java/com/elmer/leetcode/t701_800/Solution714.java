package com.elmer.leetcode.t701_800;

public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int buy = -prices[0] - fee, sell = 0;
        for (int i = 1; i < n; i++) {
            int tmp = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, tmp - prices[i] - fee);
        }
        return sell;
    }
}

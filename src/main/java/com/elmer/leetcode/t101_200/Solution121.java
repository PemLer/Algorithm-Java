package com.elmer.leetcode.t101_200;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            res = Math.max(prices[i] - minPrice, res);
        }
        return res;
    }
}

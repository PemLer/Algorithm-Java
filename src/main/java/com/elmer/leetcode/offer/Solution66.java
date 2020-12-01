package com.elmer.leetcode.offer;

import java.util.Arrays;

public class Solution66 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        if (n == 0) return new int[0];
        int[] pre = new int[n+2], post = new int[n+2];
        Arrays.fill(pre, 1);
        Arrays.fill(post, 1);
        for (int i = 1; i <= n; i++) {
            int j = n - i;
            pre[i] = pre[i-1] * a[i-1];
            post[j] = post[j+1] * a[j];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = pre[i] * post[i+1];
        }
        return res;
    }
}

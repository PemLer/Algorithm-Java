package com.elmer.leetcode.t201_300;

public class Solution264 {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int p1 = 0, p2 = 0, p3 = 0;
        for (int i = 1; i < n; i++) {
            int v1 = res[p1] * 2;
            int v2 = res[p2] * 3;
            int v3 = res[p3] * 5;
            res[i] = Math.min(Math.min(v1, v2), v3);
            if (v1 == res[i]) p1++;
            if (v2 == res[i]) p2++;
            if (v3 == res[i]) p3++;
        }
        return res[n - 1];
    }
}

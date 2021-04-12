package com.elmer.leetcode.t301_400;

public class Solution313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;
        int k = primes.length;
        int[] pointers = new int[k];

        for (int i = 1; i < n; i++) {

            int min = Integer.MAX_VALUE;
            int[] vals = new int[k];
            for (int j = 0; j < k; j++) {
                vals[j] = primes[j] * res[pointers[j]];
                min = Math.min(min, vals[j]);
            }
            for (int j = 0; j < k; j++) {
                if (vals[j] == min) {
                    pointers[j]++;
                }
            }
            res[i] = min;
        }
        return res[n - 1];
    }
}

package com.elmer.leetcode.t001_100;

public class Solution60 {

    boolean[] used;
    int[] factorial;
    int n;
    int k;
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        used = new boolean[n + 1];
        calFactorial(n);
        StringBuilder path = new StringBuilder();
        dfs(0, path);
        return path.toString();
    }

    private void dfs(int index, StringBuilder path) {
        if (index == n) {
            return;
        }
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            used[i] = true;
            path.append(i);
            dfs(index + 1, path);
            return;
        }
    }

    private void calFactorial(int n) {
        factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

}

package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution52 {
    boolean[] useCol;
    boolean[] useSlopeLeft;
    boolean[] useSlopeRight;
    int n;
    char[][] grid;
    List<List<String>> res;
    public int totalNQueens(int n) {
        /*
            00 01 02 03    3 2 1 0
            10 11 12 13    4 3 2 1
            20 21 22 23    5 4 3 2
         */
        useCol = new boolean[n];
        useSlopeLeft = new boolean[2 * n - 1];  // i + j
        useSlopeRight = new boolean[2 * n - 1]; // (n - j - 1) + i
        this.n = n;
        grid = new char[n][n];
        res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], '.');
        }
        dfs(0);
        return res.size();
    }

    private void dfs(int i) {
        if (i == n) {
            List<String> tmp = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                tmp.add(String.valueOf(grid[k]));
            }
            res.add(tmp);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (useCol[j] || useSlopeLeft[i + j] || useSlopeRight[n - j - 1 + i]) {
                continue;
            }
            grid[i][j] = 'Q';
            useCol[j] = true;
            useSlopeLeft[i + j] = true;
            useSlopeRight[n - j - 1 + i] = true;
            dfs(i + 1);
            grid[i][j] = '.';
            useCol[j] = false;
            useSlopeLeft[i + j] = false;
            useSlopeRight[n - j - 1 + i] = false;
        }
    }
}

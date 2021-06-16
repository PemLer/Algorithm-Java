package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution51 {
    char[][] matrix;
    boolean[] rows;
    boolean[] cols;
    int n;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        matrix = new char[n][n];
        rows = new boolean[n];
        cols = new boolean[n];
        this.n = n;
        res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], '.');
        }
        dfs(n, 0);
        return res;
    }

    private void addRes() {
        List<String> r = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            r.add(String.valueOf(matrix[i]));
        }
        res.add(r);
    }

    private void dfs(int remain, int row) {
        if (remain == 0) {
            addRes();
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!rows[row] && !cols[j] && matrix[row][j] == '.') {
                matrix[row][j] = 'Q';
                if (isValid(row, j)) {
                    rows[row] = true;
                    cols[j] = true;
                    dfs(remain - 1, row + 1);
                    rows[row] = false;
                    cols[j] = false;
                }
                matrix[row][j] = '.';
            }
        }
    }

    private boolean isValid(int i, int j) {
        matrix[i][j] = '.';
        int x = i - Math.min(i, j), y = j - Math.min(i, j);
        while (x < n && y < n) {
            if (matrix[x][y] == 'Q') {
                return false;
            }
            x++;
            y++;
        }

        x = i - Math.min(i, n - j - 1);
        y = j + Math.min(i, n - 1 - j);
        while (x < n && y >= 0) {
            if (matrix[x][y] == 'Q') {
                return false;
            }
            x++;
            y--;
        }
        matrix[i][j] = 'Q';
        return true;
    }
}

package com.elmer.leetcode.t101_200;

public class Solution200 {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] mem;
    char[][] grid;
    int row, col;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int n = grid.length, m = grid[0].length;
        row = n;
        col = m;
        mem = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !mem[i][j]) {
                    mem[i][j] = true;
                    dfs(i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < row && y >= 0 && y < col && !mem[x][y] && grid[x][y] == '1') {
                mem[x][y] = true;
                dfs(x, y);
            }
        }
    }
}

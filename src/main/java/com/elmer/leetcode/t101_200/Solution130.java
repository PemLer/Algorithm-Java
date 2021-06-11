package com.elmer.leetcode.t101_200;

public class Solution130 {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    char[][] board;
    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '.';
                dfs(i, 0);
            }
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = '.';
                dfs(i, n - 1);
            }
        }

        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = '.';
                dfs(0, j);
            }
            if (board[m - 1][j] == 'O') {
                board[m - 1][j] = '.';
                dfs(m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j) {
        for (int c = 0; c < 4; c++) {
            int x = i + dx[c], y = j + dy[c];
            if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == 'X' || board[x][y] == '.') {
                continue;
            }
            board[x][y] = '.';
            dfs(x, y);
        }
    }
}

package com.elmer.leetcode.t001_100;

public class Solution37 {
    char[][] board;
    public void solveSudoku(char[][] board) {
        this.board = board;
        dfs();
    }

    private boolean dfs() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        board[x][y] = (char) (k + '0');
                        if (isValid(x, y) && dfs()) {
                            return true;
                        }
                        board[x][y] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int i, int j) {
        // row
        char c = board[i][j];
        board[i][j] = '.';
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c) {
                return false;
            }
        }
        // col
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == c) {
                return false;
            }
        }
        // unit
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                int x = (i / 3) * 3 + m;
                int y = (j / 3) * 3 + n;
                if (board[x][y] == c) {
                    return false;
                }
            }
        }
        board[i][j] = c;
        return true;
    }
}

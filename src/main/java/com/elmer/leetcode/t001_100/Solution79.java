package com.elmer.leetcode.t001_100;

public class Solution79 {
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};
    private int row;
    private int col;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        row = board.length;
        col = board[0].length;
        boolean[][] mem = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!mem[i][j] && word.charAt(0) == board[i][j]) {
                    mem[i][j] = true;
                    if (dfs(board, i, j, word, 1, mem)) return true;
                    mem[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] mem) {
        if (index == word.length()) return true;

        for (int c = 0; c < 4; c++) {
            int t1 = i + dx[c];
            int t2 = j + dy[c];
            if (t1 >= 0 && t1 < row && t2 >= 0 && t2 < col && !mem[t1][t2] && word.charAt(index) == board[t1][t2]) {
                mem[t1][t2] = true;
                if (dfs(board, t1, t2, word, index+1, mem)) return true;
                mem[t1][t2] = false;
            }
        }
        return false;
    }
}

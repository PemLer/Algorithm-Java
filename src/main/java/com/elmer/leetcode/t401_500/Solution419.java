package com.elmer.leetcode.t401_500;

public class Solution419 {
    public int countBattleships(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return 0;
        int n = board.length, m = board[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (i > 0 && board[i-1][j] == 'X') {
                    continue;
                } else if (j > 0 && board[i][j-1] == 'X') {
                    continue;
                } else {
                    res++;
                }
            }
        }
        return res;
    }
}

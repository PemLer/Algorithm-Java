package com.elmer.leetcode.t001_100;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSets = new HashSet[9];
        HashSet<Character>[] colSets = new HashSet[9];
        HashSet<Character>[] boxSets = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            boxSets[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int boxId = i / 3 * 3 + j / 3;
                    char c = board[i][j];
                    if (!rowSets[i].contains(c) && !colSets[j].contains(c) && !boxSets[boxId].contains(c)) {
                        rowSets[i].add(c);
                        colSets[j].add(c);
                        boxSets[boxId].add(c);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

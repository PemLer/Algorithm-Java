package com.elmer.leetcode.t001_100;

import java.util.HashMap;
import java.util.Map;

public class Solution87 {

    private int[][][] mem;
    private String s1;
    private String s2;

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        mem = new int[n][n][n+1];
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, n);
    }

    private boolean dfs(int i, int j, int len) {
        if (mem[i][j][len] != 0) {
            return mem[i][j][len] == 1;
        }
        if (s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
            return true;
        }
        // 剪枝
        if (!checkFreq(i, j, len)) {
            mem[i][j][len] = -1;
            return false;
        }

        for (int k = 1; k < len; k++) {
            // 不交换
            if (dfs(i, j, k) && dfs(i + k, j + k, len - k)) {
                mem[i][j][len] = 1;
                return true;
            }
            // 交换
            if (dfs(i, j + len - k, k) && dfs(i + k, j, len - k)) {
                mem[i][j][len] = 1;
                return true;
            }
        }
        mem[i][j][len] = -1;
        return false;
    }

    private boolean checkFreq(int i, int j, int len) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int k = i; k < i + len; k++) {
            char c = s1.charAt(k);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int k = j; k < j + len; k++) {
            char c = s2.charAt(k);
            freq.put(c, freq.getOrDefault(c, 0) - 1);
        }
        for (int f : freq.values()) {
            if (f != 0) {
                return false;
            }
        }
        return true;
    }
}

package com.elmer.leetcode.t801_;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1006 {
    public int clumsy(int N) {
        int res = -1, tmp;
        while (N > 0) {
            if (N > 4) {
                tmp = N + 1;
                N -= 3;
            } else if (N == 4 || N == 3) {
                tmp = (N + 1) + (5 - N);
                N -= 3;
            } else if (N == 2) {
                tmp = N * (N - 1);
                N -= 2;
            } else {
                tmp = N;
                N -= 1;
            }
            res = res == -1 ? tmp : res - tmp;
            if (N >= 1) {
                res += N;
                N--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1006 sol = new Solution1006();
        System.out.println(sol.clumsy(4));
    }
}

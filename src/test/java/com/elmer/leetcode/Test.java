package com.elmer.leetcode;

import com.elmer.leetcode.common.ListNode;
import com.elmer.leetcode.common.TreeNode;

import java.util.*;


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class Test {

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Math.max(i, j);
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        List<Map.Entry<String, Integer>> list = new ArrayList<>();

        Set<Map.Entry<String, Integer>> set = new TreeSet<>(Comparator.comparingInt(Map.Entry::getValue));



        return;
    }
}

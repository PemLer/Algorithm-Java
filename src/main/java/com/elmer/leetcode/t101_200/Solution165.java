package com.elmer.leetcode.t101_200;

import javafx.util.Pair;

public class Solution165 {
    public int compareVersion(String version1, String version2) {
        int l1 = version1.length(), l2 = version2.length();
        int p1 = 0, p2 = 0, val1, val2;
        while (p1 < l1 || p2 < l2) {
            Pair<Integer, Integer> pair1 = getNextChunk(version1, l1, p1);
            val1 = pair1.getKey();
            p1 = pair1.getValue();
            Pair<Integer, Integer> pair2 = getNextChunk(version2, l2, p2);
            val2 = pair2.getKey();
            p2 = pair2.getValue();
            if (val1 == val2) {
            } else if (val1 < val2) return -1;
            else return 1;
        }
        return 0;
    }

    private Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
        if (p >= n) return new Pair<>(0, p);
        int e = p + 1;
        while (e < n && version.charAt(e) != '.') {
            e++;
        }
        return new Pair<>(Integer.parseInt(version.substring(p, e)), e + 1);
    }
}

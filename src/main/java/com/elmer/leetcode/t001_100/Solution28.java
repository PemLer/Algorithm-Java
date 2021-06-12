package com.elmer.leetcode.t001_100;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int n1 = haystack.length(), n2 = needle.length();
        if (n1 == n2) {
            return haystack.equals(needle) ? 0 : -1;
        }
        for (int i = 0; i <= n1 - n2; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean isFound = true;
                for (int j = 1; j < n2; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        isFound = false;
                        break;
                    }
                }
                if (isFound) {
                    return i;
                }
            }
        }
        return -1;
    }
}

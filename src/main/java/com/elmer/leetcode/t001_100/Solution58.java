package com.elmer.leetcode.t001_100;

public class Solution58 {
    public int lengthOfLastWord(String s) {
        int n = s.length(), i = n - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int end = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            if (i != end) {
                return end - i;
            }
        }
        return 0;
    }
}

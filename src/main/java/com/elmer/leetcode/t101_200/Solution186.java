package com.elmer.leetcode.t101_200;

public class Solution186 {
    public void reverseWords(char[] s) {
        int n = s.length;
        reverse(s, 0, n - 1);
        int start = 0, i = 0;
        while (i < n) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                i++;
                start = i;
            }
            i++;
        }
        reverse(s, start, n - 1);
    }

    private void reverse(char[] s, int start, int end) {
        for (int i = start; i < (end + start + 1) / 2; i++) {
            char tmp = s[i];
            s[i] = s[end - (i -  start)];
            s[end - (i -  start)] = tmp;
        }
    }
}

package com.elmer.leetcode.t001_100;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        int right = -1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i-1));
            }
            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            res = Math.max(res, right - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
    }
}

package com.elmer.leetcode.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution48 {
//    public int lengthOfLongestSubstring(String s) {
//        if ("".equals(s))  return 0;
//        int n = s.length();
//        Map<Character, Integer> map = new HashMap<>();
//        int[] dp = new int[n+1];
//        int res = 0;
//        for (int i = 1; i <= n; i++) {
//            char ch = s.charAt(i-1);
//            if (!map.containsKey(ch) || i - 2 - dp[i-1] >= map.get(ch)) {
//                dp[i] = dp[i-1] + 1;
//                map.put(ch, i-1);
//            } else {
//                dp[i] = i - 1 - map.get(ch);
//                map.put(ch, i-1);
//            }
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }

    // 双指针
    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s))  return 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch));
            }
            map.put(ch, i);
            res = Math.max(res, i - left);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution48 sol = new Solution48();
        sol.lengthOfLongestSubstring("abba");
    }
}

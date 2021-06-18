package com.elmer.leetcode.t001_100;

import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    Map<Character, Integer> oriCount;
    Map<Character, Integer> curCount;
    public String minWindow(String s, String t) {
        oriCount = new HashMap<>();
        curCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            oriCount.put(c, oriCount.getOrDefault(c, 0) + 1);
        }

        int minLen = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int left = 0, right = 0, n = s.length(), valid = 0;
        while (right < n) {
            char c = s.charAt(right);
            curCount.put(c, curCount.getOrDefault(c, 0) + 1);

            if (curCount.get(c).equals(oriCount.getOrDefault(c, 0))) {
                valid++;
            }
            while (valid == oriCount.size()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ansL = left;
                    ansR = right;
                }
                char tc = s.charAt(left);
                if (oriCount.get(tc).equals(curCount.getOrDefault(tc, 0))) {
                    valid--;
                }
                curCount.put(tc, curCount.getOrDefault(tc, 0) - 1);
                left++;
            }
            right++;
        }
        return ansL != -1 ? s.substring(ansL, ansR + 1) : "";
    }
}

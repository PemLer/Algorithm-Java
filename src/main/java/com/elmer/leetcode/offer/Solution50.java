package com.elmer.leetcode.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution50 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        for (char c : chars) {
            if (map.get(c) == 1) return c;
        }
        return ' ';
    }
}

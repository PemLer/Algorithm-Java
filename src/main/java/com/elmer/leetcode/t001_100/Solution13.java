package com.elmer.leetcode.t001_100;

import java.util.HashMap;
import java.util.Map;

public class Solution13 {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }};
        int res = 0, i = 0, n = s.length();
        while (i < n) {
            if (i < n - 1) {
                String sub = s.substring(i, i + 2);
                if (map.containsKey(sub)) {
                    i += 2;
                    res += map.get(sub);
                    continue;
                }
            }
            res += map.get(String.valueOf(s.charAt(i)));
            i++;
        }
        return res;
    }
}

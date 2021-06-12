package com.elmer.leetcode.t001_100;

import java.util.HashMap;
import java.util.Map;

public class Solution13 {
    public int romanToInt(String s) {
        int[] map = new int[26];
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
        int res = 0, i = 0, n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (i < n - 1 && map[c - 'A'] < map[s.charAt(i + 1) - 'A']) {
                res += (map[s.charAt(i + 1) - 'A'] - map[c - 'A']);
                i += 2;
            } else {
                res += map[c - 'A'];
                i++;
            }
        }
        return res;
    }
}

package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = new char[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                chars[c - 'a'] += 1;
            }
            StringBuilder builder = new StringBuilder();
            for (char c : chars) {
                builder.append(c);
                builder.append("|");  // 当个数超过10个时，1 0 10 0 和 10 1 0 0
            }
            String key = builder.toString();
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(s);
                map.put(key, tmp);
            }
        }
        return new ArrayList<>(map.values());
    }
}

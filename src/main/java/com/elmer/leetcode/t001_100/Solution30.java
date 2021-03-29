package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution30 {

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>(), mapTmp = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int len = words[0].length();
        int window = len * words.length;
        int n = s.length();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= n - window; i++) {
            mapTmp.clear();
            for (int j = i; j < i + window; ) {
                String t = s.substring(j, j + len);
                if (!map.containsKey(t)) {
                    break;
                }
                int c = mapTmp.getOrDefault(t, 0) + 1;
                if (c > map.get(t)) {
                    break;
                }
                mapTmp.put(t, c);
                j += len;
            }
            if (map.equals(mapTmp)) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution30 sol = new Solution30();
        String s = "aaa";
        String[] ss = {"a","a"};
        System.out.println(sol.findSubstring(s, ss));
    }
}

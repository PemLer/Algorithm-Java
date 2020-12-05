package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
    Map<Character, char[]> map;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) return new ArrayList<>();
        map = new HashMap<Character, char[]>() {{
            put('2', new char[]{'a', 'b', 'c'});
            put('3', new char[]{'d', 'e', 'f'});
            put('4', new char[]{'g', 'h', 'i'});
            put('5', new char[]{'j', 'k', 'l'});
            put('6', new char[]{'m', 'n', 'o'});
            put('7', new char[]{'p', 'q', 'r', 's'});
            put('8', new char[]{'t', 'u', 'v'});
            put('9', new char[]{'w', 'x', 'y', 'z'});
        }};
        res = new ArrayList<>();
        dfs(digits, 0, new StringBuilder());
        return res;
    }

    private void dfs(String digits, int i, StringBuilder chars) {
        if (i == digits.length()) {
            res.add(chars.toString());
            return;
        }

        for (char c : map.get(digits.charAt(i))) {
            chars.append(c);
            dfs(digits, i + 1, chars);
            chars.deleteCharAt(chars.length() -  1);
        }
    }
}

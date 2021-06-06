package com.elmer.leetcode.offer;

import java.util.HashMap;

public class Solution20 {
    public boolean isNumber(String s) {
        /*
            s: +-
            d: 0-9
            e: e
            .: .
            _: _
            ?: unknown
            ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123", ".56", "3.", "-.9"]
         */
        HashMap<Character, Integer>[] states = new HashMap[9];
        // 0 开始的空格
        states[0] = new HashMap<Character, Integer>(){{
            put(' ', 0);
            put('s', 1);
            put('d', 2);
            put('.', 4);
        }};
        // 1 e之前的符号
        states[1] = new HashMap<Character, Integer>(){{
            put('d', 2);
            put('.', 4);
        }};
        // 2 e之前的数字
        states[2] = new HashMap<Character, Integer>(){{
            put('d', 2);
            put('.', 3);
            put('e', 5);
            put(' ', 8);
        }};
        // 3 e之前的小数点及数字
        states[3] = new HashMap<Character, Integer>(){{
            put('d', 3);
            put('e', 5);
            put(' ', 8);
        }};
        // 4 当小数点前为空格时，小数点及数字
        states[4] = new HashMap<Character, Integer>(){{
            put('d', 3);
        }};
        // 5 e
        states[5] = new HashMap<Character, Integer>(){{
            put('s', 6);
            put('d', 7);
        }};
        // 6 e之后的符号
        states[6] = new HashMap<Character, Integer>(){{
            put('d', 7);
        }};
        // 7 e之后的数字
        states[7] = new HashMap<Character, Integer>(){{
            put('d', 7);
            put(' ', 8);
        }};
        // 8 末尾的空格
        states[8] = new HashMap<Character, Integer>(){{
            put(' ', 8);
        }};

        int p = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ' || c == '.' || c == 'e') {

            } else if (c == 'E') {
                c = 'e';
            } else if (c >= '0' && c <= '9') {
                c = 'd';
            } else if (c == '+' || c == '-') {
                c = 's';
            } else {
                c = '?';
            }
            if (!states[p].containsKey(c)) {
                return false;
            }
            p = states[p].get(c);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}

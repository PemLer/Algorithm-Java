package com.elmer.leetcode.t001_100;

import java.util.HashMap;

public class Solution65 {
    public boolean isNumber(String s) {
        /*
            0 开始的空格
            1 e之前的符号
            2 e之前的数字
            3 e之前的小数点及数字
            4 当小数点前为空格时的小数点
            5 e
            6 e之后的符号
            7 e之后的数字
            8 末尾的空格
         */
        HashMap[] states = new HashMap[9];
        states[0] = new HashMap(){{
            put(' ', 0); put('s', 1); put('d', 2); put('.', 4);
        }};
        states[1] = new HashMap() {{
            put('d', 2); put('.', 4);
        }};
        states[2] = new HashMap() {{
            put('d', 2); put('.', 3); put('e', 5); put(' ', 8);
        }};
        states[3] = new HashMap() {{
            put('d', 3); put('e', 5); put(' ', 8);
        }};
        states[4] = new HashMap() {{
            put('d', 3);
        }};
        states[5] = new HashMap() {{
            put('s', 6); put('d', 7);
        }};
        states[6] = new HashMap() {{
            put('d', 7);
        }};
        states[7] = new HashMap() {{
            put('d', 7); put(' ', 8);
        }};
        states[8] = new HashMap() {{
            put(' ', 8);
        }};

        int state = 0;
        char symbol = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'e' || c == 'E') {
                symbol = 'e';
            } else if (c == '-' || c == '+') {
                symbol = 's';
            } else if (c >= '0' && c <= '9') {
                symbol = 'd';
            } else if (c == ' ') {
                symbol = ' ';
            } else if (c == '.') {
                symbol = '.';
            } else {
                return false;
            }
            if (!states[state].containsKey(symbol)) {
                return false;
            }
            state = (int) states[state].get(symbol);
        }
        return state == 2 || state == 3 || state == 7 || state == 8;
    }
}

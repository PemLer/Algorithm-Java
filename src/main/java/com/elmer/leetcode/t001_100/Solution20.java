package com.elmer.leetcode.t001_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('}', '{');
            put(')', '(');
            put(']', '[');
        }};
        for  (int i  = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) return false;
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }
}

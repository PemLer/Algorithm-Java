package com.elmer.leetcode.t001_100;

import java.util.Deque;
import java.util.LinkedList;

public class Solution71 {
    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        int i = 0, n = path.length();
        while (i < n) {
            if (path.charAt(i) == '/') {
                i++;
            } else {
                StringBuilder builder = new StringBuilder();
                while (i < n && path.charAt(i) != '/') {
                    builder.append(path.charAt(i));
                    i++;
                }
                String s = builder.toString();
                if ("..".equals(s)) {
                    deque.pollLast();
                } else if (".".equals(s)) {
                    continue;
                } else {
                    deque.addLast(builder.toString());
                }
            }
        }

        return "/" + String.join("/", deque);
//        StringBuilder res = new StringBuilder("/");
//        while (!deque.isEmpty()) {
//            res.append(deque.pollFirst());
//            res.append("/");
//        }
//        if (res.length() > 1) {
//            res.deleteCharAt(res.length() - 1);
//        }
//        return res.toString();
    }

    public static void main(String[] args) {
        Solution71 sol = new Solution71();
        sol.simplifyPath("/...");
    }
}

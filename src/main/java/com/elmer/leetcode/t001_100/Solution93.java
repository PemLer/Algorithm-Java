package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    List<String> res;
    List<String> tmp;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        tmp = new ArrayList<>();
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int index) {
        if (tmp.size() == 4 && index == s.length()) {
            res.add(String.join(".", tmp));
            return;
        }
        if (tmp.size() == 4 && index < s.length()) {
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (isValidNum(s, index, len)) {
                tmp.add(s.substring(index, index + len));
                dfs(s, index+len);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean isValidNum(String s, int i, int len) {
        if (i + len > s.length()) return false;
        String sub = s.substring(i, i + len);
        if (sub.length() > 1 && sub.charAt(0) == '0') return false;
        int num = Integer.parseInt(sub);
        return num <= 255;
    }
}

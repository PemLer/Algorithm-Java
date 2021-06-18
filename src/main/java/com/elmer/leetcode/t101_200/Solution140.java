package com.elmer.leetcode.t101_200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution140 {
    List<String> tmp;
    List<String> res;
    Set<String> wordCount;
    String s;
    int minLen, maxLen;

    public List<String> wordBreak(String s, List<String> wordDict) {
        tmp = new ArrayList<>();
        res = new ArrayList<>();
        wordCount = new HashSet<>();
        this.s = s;
        minLen = Integer.MAX_VALUE;
        maxLen = Integer.MIN_VALUE;
        for (String word : wordDict) {
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
            wordCount.add(word);
        }
        dfs(0);
        return res;
    }

    private void dfs(int x) {
        if (x == s.length()) {
            res.add(String.join(" ", tmp));
            return;
        }
        for (int j = x + minLen; j <= Math.min(x + maxLen, s.length()); j++) {
            String w = s.substring(x, j);
            if (wordCount.contains(w)) {
                tmp.add(w);
                dfs(j);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}

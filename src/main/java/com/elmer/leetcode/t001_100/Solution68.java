package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.List;

public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>(), tmp = new ArrayList<>();
        int curLen = 0, n = words.length;

        for (int k = 0; k < n; k++) {
            if (!canAdd(words[k], tmp, curLen, maxWidth)) {
                res.add(format(tmp, curLen, maxWidth));
                tmp.clear();
                curLen = 0;
            }
            tmp.add(words[k]);
            curLen += words[k].length();
        }
        StringBuilder builder = new StringBuilder();
        builder.append(String.join(" ", tmp));
        int t = builder.length();
        for (int i = 0; i < maxWidth - t; i++) {
            builder.append(" ");
        }
        res.add(builder.toString());
        return res;
    }

    private boolean canAdd(String word, List<String> tmp, int curLen, int maxWidth) {
        int total = curLen + word.length() + tmp.size();
        return total <= maxWidth;
    }

    private String format(List<String> tmp, int curLen, int maxWidth) {
        StringBuilder builder = new StringBuilder();
        if (tmp.size() == 1) {
            builder.append(tmp.get(0));
            for (int i = 0; i < (maxWidth - tmp.get(0).length());i++) {
                builder.append(" ");
            }
            return builder.toString();
        }

        int min = (maxWidth - curLen) / (tmp.size() - 1);
        int maxSize = (maxWidth - curLen) - (min * (tmp.size() - 1));
        int minSize = tmp.size() - 1 - maxSize;
        for (String word : tmp) {
            if (maxSize > 0) {
                builder.append(word);
                for (int i = 0; i < min + 1; i++) {
                    builder.append(" ");
                }
                maxSize--;
            } else {
                builder.append(word);
                if (minSize > 0) {
                    for (int i = 0; i < min; i++) {
                        builder.append(" ");
                    }
                }
                minSize--;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        Solution68 sol = new Solution68();
        List<String> res = sol.fullJustify(words, maxWidth);
        for (String r : res) {
            System.out.println("\"" + r + "\"");
        }

    }

}

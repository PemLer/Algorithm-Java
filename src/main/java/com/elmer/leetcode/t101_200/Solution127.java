package com.elmer.leetcode.t101_200;

import java.util.*;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>(), tmp;
        Set<String> hasUsed = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);
        hasUsed.add(beginWord);
        queue.add(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            tmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                String word = queue.poll();
                char[] chars = word.toCharArray();
                for (int k = 0; k < chars.length; k++) {
                    char ori = chars[k];
                    for (int i = 0; i < 26; i++) {
                        if ('a' + i == chars[k]) continue;
                        chars[k] = (char) ('a' + i);
                        String wordNew = String.valueOf(chars);
                        chars[k] = ori;
                        if (words.contains(wordNew) && !hasUsed.contains(wordNew)) {
                            if (wordNew.equals(endWord)) return count;
                            tmp.add(wordNew);
                            hasUsed.add(wordNew);
                        }
                    }
                }
            }
            queue = tmp;
        }
        return 0;
    }
}

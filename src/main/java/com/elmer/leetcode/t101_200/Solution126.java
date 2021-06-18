package com.elmer.leetcode.t101_200;

import java.util.*;

public class Solution126 {
    List<List<String>> res;
    Map<String, List<String>> map;
    String begin;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int layer = 1;
        Set<String> words = new HashSet<>(wordList);
        Map<String, Integer> record = new HashMap<>();
        map = new HashMap<>();
        begin = beginWord;
        res = new ArrayList<>();
        if (!words.contains(endWord)) {
            return res;
        }
        boolean isFound = false;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            layer++;
            Queue<String> tmp = new LinkedList<>();
            for (String word : queue) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char t = chars[i];
                    for (int c = 0; c < 26; c++) {
                        chars[i] = (char) (c + 'a');
                        String newWord = String.valueOf(chars);
                        if (words.contains(newWord) && (!record.containsKey(newWord) || record.get(newWord) == layer)) {
                            record.put(newWord, layer);
                            if (!map.containsKey(newWord)) {
                                map.put(newWord, new ArrayList<>());
                                tmp.add(newWord);
                            }
                            map.get(newWord).add(word);
                            if (newWord.equals(endWord)) {
                                isFound = true;
                            }
                        }
                    }
                    chars[i] = t;
                }
            }
            if (record.containsKey(endWord)) {
                break;
            }
            queue = tmp;
        }

        if (!isFound) {
            return res;
        }

        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(endWord, path);
        return res;
    }

    private void dfs(String word, List<String> path) {
        if (word.equals(begin)) {
            List<String> tmp = new ArrayList<>();
            for (int i = path.size() - 1; i >= 0; i--) {
                tmp.add(path.get(i));
            }
            res.add(tmp);
            return;
        }
        for (String next : map.get(word)) {
            path.add(next);
            dfs(next, path);
            path.remove(path.size() - 1);
        }
    }
}

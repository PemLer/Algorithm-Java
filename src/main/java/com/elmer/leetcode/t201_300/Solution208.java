package com.elmer.leetcode.t201_300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution208 {
}

class Node {

    Map<Character, Node> charSet;
    boolean isEnd;
    Node() {
        charSet = new HashMap<>();
        isEnd = false;
    }

    public void addChar(char c) {
        charSet.put(c, new Node());
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public boolean contains(char c) {
        return charSet.containsKey(c);
    }

    public Node getNext(char c) {
        return charSet.get(c);
    }
}


class Trie {

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.contains(c)) {
                node.addChar(c);
            }
            node = node.getNext(c);
        }
        node.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.contains(c)) {
                node = node.getNext(c);
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (node.contains(c)) {
                node = node.getNext(c);
            } else {
                return false;
            }
        }
        return true;
    }
}

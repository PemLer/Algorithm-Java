package com.elmer.leetcode.t201_300;

import java.util.ArrayList;
import java.util.List;

public class Solution212 {

    class TrieNode {
        TrieNode[] trieNodes;
        boolean isEnd;

        TrieNode() {
            trieNodes = new TrieNode[26];
            isEnd = false;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public boolean hasNext(char c) {
            return trieNodes[c - 'a'] != null;
        }

        public void add(char c) {
            trieNodes[c - 'a'] = new TrieNode();
        }

        public boolean isEnd() {
            return isEnd;
        }

        public TrieNode getNext(char c) {
            return trieNodes[c - 'a'];
        }

        public void addWord(String word) {
            TrieNode node = this;
            for (char c : word.toCharArray()) {
                if (!node.hasNext(c)) {
                    node.add(c);
                }
                node = node.getNext(c);
            }
            node.setEnd(true);
        }
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    List<String> res;
    int n, m;

    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }
        n = board.length;
        m = board[0].length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (root.hasNext(board[i][j])) {
                    char c = board[i][j];
                    board[i][j] = '#';
                    builder.append(c);
                    dfs(board, root.getNext(c), i, j, builder);
                    board[i][j] = c;
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, TrieNode node, int i, int j, StringBuilder builder) {
        if (node.isEnd()) {
            String s = builder.toString();
            node.setEnd(false);
            res.add(s);
        }
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < n && y >= 0 && y < m && board[x][y] != '#' && node.hasNext(board[x][y])) {
                char c = board[x][y];
                board[x][y] = '#';
                builder.append(c);
                dfs(board, node.getNext(c), x, y, builder);
                board[x][y] = c;
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution212 sol = new Solution212();
        char[][] board = new char[4][];
        board[0] = new char[]{'o', 'a', 'a', 'n'};
        board[1] = new char[]{'e','t','a','e'};
        board[2] = new char[]{'i','h','k','r'};
        board[3] = new char[]{'i','f','l','v'};
        String[] words = {"oath","pea","eat","rain"};
        sol.findWords(board, words);
    }
}

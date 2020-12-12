package com.elmer.leetcode.t101_200;

import java.util.*;


public class Solution133 {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        int val = node.val;
        Node nodeNew = new Node(val);
        map.put(node, nodeNew);
        List<Node> neighbors = new ArrayList<>();
        for (Node node1 : node.neighbors) {
            neighbors.add(cloneGraph(node1));
        }
        nodeNew.neighbors = neighbors;
        return nodeNew;
    }
}

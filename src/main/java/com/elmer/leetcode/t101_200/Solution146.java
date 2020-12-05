package com.elmer.leetcode.t101_200;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {

    class Node {

        int key;
        int val;
        Node post;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class LRUCache {

        int capacity;
        Map<Integer, Node> map;
        Node head;
        Node tail;
        int cnt;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.post = head;
            cnt = 0;
        }

        private void toTail(Node node) {
            Node lastTwo = tail.post;
            lastTwo.next = node;
            node.post = lastTwo;
            node.next = tail;
            tail.post = node;
        }

        private void release(Node node) {
            Node before = node.post;
            Node after = node.next;
            before.next = after;
            after.post = before;
        }

        private void removeFirst() {
            Node nodeRemove = head.next;
            nodeRemove.next.post = head;
            head.next = nodeRemove.next;
            map.remove(nodeRemove.key);
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                release(node);
                toTail(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                toTail(node);
                return;
            }

            Node node = new Node(key, value);
            if (cnt == capacity) {
                removeFirst();
                toTail(node);
                map.put(key, node);
            } else {
                map.put(key, node);
                toTail(node);
                cnt++;
            }
        }
    }

}

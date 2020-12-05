package com.elmer.leetcode.t401_500;

import java.util.HashMap;
import java.util.Map;

public class Solution460 {

}

class Node {
    int key;
    int val;
    int freq;
    Node next;
    Node pre;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        freq = 1;
    }
}

class DLinkedList {

    Node head;
    Node tail;

    public DLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public void add(Node node) {
        Node tmp = tail.pre;
        tmp.next = node;
        node.pre = tmp;
        node.next = tail;
        tail.pre = node;
    }

    public Node remove() {
        Node tmp = head.next;
        head.next = tmp.next;
        tmp.next.pre = head;
        return tmp;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

}

class LFUCache {

    int capacity;
    int count;
    Map<Integer, Node> nodeMap;
    Map<Integer, DLinkedList> freqMap;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
    }

    private void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void add(Node node) {
        int freq = node.freq;
        if (freqMap.containsKey(freq)) {
            freqMap.get(freq).add(node);
        } else {
            freqMap.put(freq, new DLinkedList());
            freqMap.get(freq).add(node);
        }
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            remove(node);
            if (freqMap.get(node.freq).isEmpty() && node.freq == minFreq) minFreq++;
            node.freq++;
            add(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            remove(node);
            if (freqMap.get(node.freq).isEmpty() && minFreq == node.freq) minFreq++;
            node.freq++;
            node.val = value;
            add(node);
        } else {
            Node node = new Node(key, value);
            if (count == capacity) {
                Node nodeRemove = freqMap.get(minFreq).remove();
                nodeMap.remove(nodeRemove.key);
                add(node);
                nodeMap.put(key, node);
            } else {
                add(node);
                nodeMap.put(key, node);
                count++;
            }
            minFreq = 1;
        }
    }
}
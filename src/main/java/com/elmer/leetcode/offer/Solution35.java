package com.elmer.leetcode.offer;

import java.util.*;



public class Solution35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

//    // 方法一 DFS
//    Map<Node, Node> visited;
//
//    public Node copyRandomList(Node head) {
//        visited = new HashMap<>();
//        return dfs(head);
//    }
//
//    private Node dfs(Node node) {
//        if (node == null) return null;
//        if (visited.containsKey(node)) return visited.get(node);
//        Node nodeCopy = new Node(node.val);
//        visited.put(node, nodeCopy);
//        nodeCopy.next = dfs(node.next);
//        nodeCopy.random = dfs(node.random);
//        return nodeCopy;
//    }

//    // 方法二 BFS
//    public Node copyRandomList(Node head) {
//        if (head == null) return null;
//        Queue<Node> queue = new LinkedList<>();
//        Map<Node, Node> visited = new HashMap<>();
//        queue.add(head);
//        Node headCopy = new Node(head.val);
//        visited.put(head, headCopy);
//        while (!queue.isEmpty()) {
//            Node node = queue.poll();
//            if (node.next != null && !visited.containsKey(node.next)) {
//                visited.put(node.next, new Node(node.next.val));
//                queue.add(node.next);
//            }
//            if (node.random != null && !visited.containsKey(node.random)) {
//                visited.put(node.random, new Node(node.random.val));
//                queue.add(node.random);
//            }
//            visited.get(node).next = visited.get(node.next);
//            visited.get(node).random = visited.get(node.random);
//        }
//        return headCopy;
//    }

//    // 方法三 迭代
//    Map<Node, Node> visited;
//    public Node copyRandomList(Node head) {
//        if (head == null) return null;
//        visited = new HashMap<>();
//        Node dummy = new Node(-1);
//        Node first = dummy;
//        while (head != null) {
//            dummy.next = copyNode(head);
//            dummy = dummy.next;
//            dummy.next = (head.next != null) ? copyNode(head.next) : null;
//            dummy.random = (head.random != null) ? copyNode(head.random) : null;
//            head = head.next;
//        }
//        return first.next;
//    }
//
//    private Node copyNode(Node node) {
//        if (visited.containsKey(node)) return visited.get(node);
//        Node nodeNew = new Node(node.val);
//        visited.put(node, nodeNew);
//        return nodeNew;
//    }

    // 方法四 优化迭代 空间复杂度O(1)
    // 先复制每个节点，然后在复制随机指针
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 复制节点
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            Node next = cur.next;
            cur.next = tmp;
            tmp.next = next;
            cur = next;
        }
        // 复制随机指针
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 断裂
        Node dummyNew = new Node(-1);
        Node curNew = dummyNew;
        cur = head;
        while (cur != null) {
            curNew.next = cur.next;
            curNew = curNew.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return dummyNew.next;
    }

}

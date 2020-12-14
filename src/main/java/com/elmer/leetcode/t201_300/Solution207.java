package com.elmer.leetcode.t201_300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution207 {
//    // DFS
//    int[] visited;
//    List<List<Integer>> adj;
//    int numCourses;
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        this.numCourses = numCourses;
//        visited = new int[numCourses];
//        adj = new ArrayList<>();
//        for (int i = 0; i < numCourses; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for (int[] rel : prerequisites) {
//            adj.get(rel[1]).add(rel[0]);
//        }
//        for (int i = 0; i < numCourses; i++) {
//            if (visited[i] == 0 && !dfs(i)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean dfs(int i) {
//        if (visited[i] == 1) return false;
//        else if (visited[i] == -1) return true;
//        visited[i] = 1;
//        for (int k : adj.get(i)) {
//            if (!dfs(k)) {
//                return false;
//            }
//        }
//        visited[i] = -1;
//        return true;
//    }

    // BFS
    List<List<Integer>> adj;
    Queue<Integer> queue;
    int[] inDegree;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        queue = new LinkedList<>();
        inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] ints : prerequisites) {
            adj.get(ints[1]).add(ints[0]);
            inDegree[ints[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int u = queue.poll();
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        return visited == numCourses;
    }
}

package com.elmer.leetcode.t201_300;

import java.util.*;

public class Solution210 {

//    // DFS
//    int[] visited;
//    List<List<Integer>> adj;
//    int numCourses;
//    int[] res;
//    int index;
//
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        visited = new int[numCourses];
//        adj = new ArrayList<>();
//        this.numCourses = numCourses;
//        res = new int[numCourses];
//        index = numCourses - 1;
//        for (int i = 0; i < numCourses; i++) {
//            adj.add(new ArrayList<>());
//        }
//
//        for (int[] ints : prerequisites) {
//            adj.get(ints[1]).add(ints[0]);
//        }
//        for (int i = 0; i < numCourses; i++) {
//            if (!dfs(i)) return new int[0];
//        }
//        return res;
//    }
//
//    private boolean dfs(int i) {
//        if (visited[i] == 1) return false;
//        else if (visited[i] == -1) return true;
//
//        visited[i] = 1;
//        for (int k : adj.get(i)) {
//            if (!dfs(k)) {
//                return false;
//            }
//        }
//        res[index--] = i;
//        visited[i] = -1;
//        return true;
//    }

    // BFS
    List<List<Integer>> adj;
    Queue<Integer> queue;
    int[] inDegree;
    int[] res;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        res = new int[numCourses];
        queue = new LinkedList<>();
        int index = 0;
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
            res[index++] = u;
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        if (visited != numCourses) return new int[0];
        return res;
    }


    public static void main(String[] args) {
        Solution210 sol = new Solution210();
        int[][] pre = new int[][]{{0, 2}, {1, 2}, {2, 0}};
        sol.findOrder(3, pre);
    }
}

package com.elmer.leetcode.graph;

import java.util.Arrays;
import java.util.List;

// DFS判断G是否有环
public class Cycle {

    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s, s);
            }
        }
    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w, v);
            } else if (w != u) hasCycle = true;  // 不能自环
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5);
        Graph G = new Graph(list);
        G.addEdge(1, 2);
        G.addEdge(1, 4);
        G.addEdge(2, 4);
        G.addEdge(2, 5);
        G.addEdge(3, 4);

        Cycle cycle = new Cycle(G);
        System.out.println(cycle.hasCycle);
    }

}

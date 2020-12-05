package com.elmer.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int V;
    private int E;
    private List<Integer>[] adj;
    public Graph(List<Integer> list) {
        V = list.size();
        E = 0;
        adj = new List[V];
        for (int v : list) {
            adj[v] = new ArrayList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public List<Integer> adj(int v) {
        return adj[v];
    }


}

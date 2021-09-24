package com.example.leetcode.tree;

public class SalesPath {
    int getCheapestCost(Node rootNode) {
        if (rootNode == null) return 0;
        return dfs(rootNode);
    }

    int dfs(Node root) {
        if (root.children.length == 0) return root.cost;

        Node[] children = root.children;
        int path = Integer.MAX_VALUE;
        for (Node child : children) {
            path = Math.min(dfs(child), path);
        }
        return path + root.cost;
    }

    static class Node {
        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }


}

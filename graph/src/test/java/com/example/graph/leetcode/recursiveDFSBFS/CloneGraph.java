package com.example.graph.leetcode.recursiveDFSBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node, Node> old2New=new HashMap<>();
        return recursiveClone(node,old2New);
    }

    public Node recursiveClone(Node node, Map<Node, Node> map){
        if(map.containsKey(node)) return map.get(node);

        Node created=new Node(node.val);
        map.put(node,created);

        for(Node neigh: node.neighbors){
            created.neighbors.add(recursiveClone(neigh, map));
        }
        return created;
    }


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
}

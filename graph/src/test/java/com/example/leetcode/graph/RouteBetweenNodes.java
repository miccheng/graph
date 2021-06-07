package com.example.leetcode.graph;

import com.example.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class RouteBetweenNodes {
    enum State{
        visited,
        unvisted,
        visiting
    }

//1. change of state points:(visiting) in the queue, (visited) its neighbours are all added to the queue
//2. state check performed before adding the node to the queue. otherwise it will result a cycle
    public boolean searchRoute(List<List<Node>> graph, Node start, Node end){
        if(start==end) return true;
        for(List<Node> list: graph){
            for(Node node:list){
                node.state=State.unvisted;
            }
        }

       LinkedList<Node> queue=new LinkedList<Node>();
        queue.add(start);
        while(!queue.isEmpty()) {
            Node current = queue.pop();
            current.state = State.visiting;
            if (current != null) {
                for (Node neighbour : current.neighbours) {
                    if (neighbour.state == State.unvisted) {//***mark to avoid cycle traversal
                        if (neighbour.equals(end)) {
                            return true;
                        } else {
                            queue.add(neighbour);
                            neighbour.state = State.visiting;
                        }
                    }
                }
            }
            current.state = State.visited;
        }

       return false;
    }



    class Node{
       int val;
       State state;
       List<Node> neighbours;
    }
}

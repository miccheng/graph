package com.example.graph.leetcode.recursiveDFSBFS;

import com.example.leetcode.tree.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2,null,node3);
        TreeNode node1 = new TreeNode(1,null,node2);
        TreeNode node0 = new TreeNode(0,null,node1);
        distanceK(node0,node0,2);
    }

    private static List<Integer> result=new ArrayList<>();
    private static Map<TreeNode, LinkedList<TreeNode>> map=new HashMap<>();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null) return result;

        if(root==target &&k==0) {
            result.add(target.val);
            return result;
        }
        buildGraph(root);
        BFS(map, target,k);
        return result;
    }


    private static void buildGraph(TreeNode root){
        if(root==null) return;

        if(!map.containsKey(root)) map.put(root, new LinkedList<TreeNode>());

        if(root.left!=null){//double directions
            map.get(root).add(root.left);
            if(!map.containsKey(root.left)) map.put(root.left, new LinkedList<TreeNode>());
            map.get(root.left).add(root);
        }
        if(root.right!=null) {
            map.get(root).add(root.right);
            if(!map.containsKey(root.right)) map.put(root.right, new LinkedList<TreeNode>());
            map.get(root.right).add(root);
        }

        buildGraph(root.left);
        buildGraph(root.right);

    }

    private static void BFS(Map <TreeNode, LinkedList<TreeNode>> map, TreeNode target,int k) {
        Set<TreeNode> visited = new HashSet<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        int layer = 0;
        while (!queue.isEmpty() && layer <= k) {
            int size = queue.size();
            if (layer == k) {
                for (int i = 0; i < size; i++) result.add(queue.poll().val);
                return;
            }
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                visited.add(cur);
                for (TreeNode negibhor : map.get(cur)) {//must check whether it is visited
                    if (!visited.contains(negibhor)) queue.add(negibhor);
                }
            }
            layer++;
        }
    }
}

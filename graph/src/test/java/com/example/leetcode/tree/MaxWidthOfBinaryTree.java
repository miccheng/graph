package com.example.leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxWidthOfBinaryTree {
    //***mark node with position number
    //**left node=2*parentNodeIndex, right node=2*parentNodeIndex+1;
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int currentWid=0;
        Map<TreeNode, Integer> map = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root,1);

        while(!queue.isEmpty()) {
            int size = queue.size();
            int start=0;
            int end=0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(i==0) {start=map.get(node);}
                if(i==size-1) {end=map.get(node);}
                if (node.left != null) {
                    queue.add(node.left);
                    map.put(node.left,map.get(node)*2);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    map.put(node.right,map.get(node)*2+1);
                }
            }

            currentWid=Math.max(currentWid,end-start+1);
        }

        return currentWid;
    }
}

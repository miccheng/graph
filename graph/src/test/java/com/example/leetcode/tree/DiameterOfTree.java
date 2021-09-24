package com.example.leetcode.tree;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

public class DiameterOfTree {
    //*** same to max path sum of a tree problem
//    private int max=Integer.MIN_VALUE;
//
//    public int diameterOfBinaryTree(TreeNode root) {
//        int length=postOrder(root);
//        //***path is the number of the vertices connecting these nodes
//        return  Math.max(max,length);
//    }
//
//    private int postOrder(TreeNode root) {
//        if (root == null) return -1;
//        int left = postOrder(root.left);
//        int right = postOrder(root.right);
//        max = Math.max(max, left + right + 2);
//        return 1 + Math.max(left, right);
//    }

    private static int max=Integer.MIN_VALUE;
    public static int diameter(Node root) {
        if(root==null) return 0;
        int result=recursive(root);
        return Math.max(result,max);
    }

    private static int recursive(Node root){
        if(root==null||root.children.size()==0) return -1;

        int layMax=0;
        int layMax2=0;
        for(Node child: root.children){
            int level=recursive(child);
            if(level>layMax){
                layMax2=layMax;
                layMax=level;
            }
            else if(level>layMax2){layMax2=level;}
        }
        max=Math.max(layMax+layMax2+2,max);
        return layMax+1;
    }

    static class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}

package com.example.leetcode.tree;

import java.util.*;
//inorder:LNR; preorder:NLR; postorder:LRN
public class TraverseTree {
    //**** a typical usage would be print boundary nodes of a tree
   public List<TreeNode> list=new ArrayList<TreeNode>();

    //preorder: recursive
    public void preorder(TreeNode root) {
        if (root == null) return;
        list.add(root);
        if (root.left != null)preorder(root.left);
        if (root.right != null)preorder(root.right);
    }

    //preorder: iterative
    public void iterative(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    //level traverse
    public void bfs(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            list.add(node);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
//        list.stream().sorted(Comparator.comparing());
    }

    //inorder
    public void inorder(TreeNode root) {
        if(root==null) return;
        if(root.left!=null) inorder(root.left);
        list.add(root);
        if(root.right!=null) inorder(root.right);
    }
}

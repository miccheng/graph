package com.example.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BoundaryTraversalOfBinaryTree {
//    split the problem into 3 parts:
//        1.traverse left boundary (downwards) preorder
//        2. all leaf nodes dfs
//        3.traverse right boundary (upwards) postorder
//      avoid duplicates: left and right boundary and the leaf nodes

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        result.add(root.val);

        traverseLeft(root.left, result);
        leaves(root.left, result);
        leaves(root.right, result);
        traverseRight(root.right, result);

        return result;
    }

    public void leaves(TreeNode root, List<Integer> nodes) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }
        leaves(root.left, nodes);
        leaves(root.right, nodes);
    }

    private void traverseLeft(TreeNode root, List<Integer> result){
        if(root==null||(root.left==null&&root.right==null)) return;
        result.add(root.val);
        if(root.left!=null)
            traverseLeft(root.left, result);
        else traverseLeft(root.right, result);
    }

    private void traverseRight(TreeNode root,  List<Integer> nodes){
        if(root == null || (root.right == null && root.left == null)) return;
        if(root.right != null)
            traverseRight(root.right,nodes);
        else traverseRight(root.left, nodes);
        nodes.add(root.val); // add after child visit(reverse)
    }
}

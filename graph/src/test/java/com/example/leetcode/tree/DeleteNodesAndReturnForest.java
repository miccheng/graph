package com.example.leetcode.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        Set<Integer> deleteNodes=new HashSet<>();
        for(int n:to_delete){
            deleteNodes.add(n);
        }
        List<TreeNode> result=new ArrayList<>();
        if(!deleteNodes.contains(root)) result.add(root);
        traverse(root,deleteNodes,result );
        return result;
    }

    private TreeNode traverse(TreeNode root, Set<Integer> deleteNodes, List<TreeNode> result){
        if(root==null) return null;

        TreeNode left=traverse(root.left,deleteNodes, result);
        TreeNode right=traverse(root.right,deleteNodes, result);
        if(deleteNodes.contains(root.val)){
            if(root.left!=null)result.add(root.left);
            if(root.right!=null)result.add(root.right );
            return null;
        }
        return root;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> set, List<TreeNode> res) {
        if (node == null) {
            return null;
        }
        node.left = dfs(node.left, set, res);
        node.right = dfs(node.right, set, res);
        if (set.contains(node.val)) {
            if (node.left != null) res.add(node.left);
            if (node.right != null) res.add(node.right);
            return null;
        }
        return node;
    }

}

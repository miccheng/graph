package com.example.leetcode.tree;

import com.example.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
//similar problem to convert sorted array to binary search tree
public class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        if(root==null) return null;
        List<Integer> result=new ArrayList<>();
        inorder(root,result);

        int len=result.size();
        return constructTree(0, len-1, result);
    }


    private void inorder(TreeNode root, List<Integer> result){
        if(root==null) return;

        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }



    private TreeNode constructTree(int beg, int end, List<Integer> result){
        if(beg==end) return new TreeNode(result.get(beg));
        if(beg>end) return null;

        int mid=beg+(end-beg)/2;
        TreeNode root=new TreeNode(result.get(mid));

        TreeNode left=constructTree(beg,mid-1,result);
        TreeNode right=constructTree(mid+1,end,result);

        root.left=left;
        root.right=right;

        return root;
    }
}

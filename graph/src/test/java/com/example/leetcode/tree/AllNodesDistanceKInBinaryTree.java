package com.example.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree {
    private static List<Integer> result=new ArrayList<>();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null) return result;

        if(root==target &&k==0) {
            result.add(target.val);
            return result;
        }

        preorder(root, target,k);
        return result;
    }


    private static int preorder(TreeNode root, TreeNode target, int k){
        if(root==null) return -1;
        if(root==target) {
            searchDown(root,0, k);
            return 1;
        }

        int left=preorder(root.left, target,k);
        if(left!=-1){
            if(k==left){
                result.add(root.val);
            }else{
                searchDown(root.right,left+1, k);
            }
            return left+1;
        }

        int right=preorder(root.right, target, k);
        if(right!=-1){
            if(k==right){
                result.add(root.val);
            }else{
                searchDown(root.left,right+1, k);
            }
            return right+1;
        }
        return -1;
    }

    private static void searchDown(TreeNode target,int cur, int k){
        if(target==null) return;
        if(cur==k){
            result.add(target.val);
        }
        searchDown(target.left, cur+1,k);
        searchDown(target.right, cur+1,k);
    }
}

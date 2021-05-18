package com.example.leetcode.tree;

import java.util.*;

public class ConstructTreeFromPreorderInorder {

     public static void main(String[] args) {
         int[] preorder = {3, 9, 20, 15, 7};
         int[] inorder = {9, 3, 15, 20, 7};
         buildTree(preorder,inorder);
         buildTree(0,0, preorder, inorder.length - 1, inorder);
     }

    public static TreeNode buildTree(int pointer,int start, int[] preorder,int end, int[] inorder) {
         if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pointer]);
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        //left
        root.left = buildTree(pointer+1, start, preorder, index - 1, inorder);
        //right: index-start is the size of left subtree
        root.right = buildTree(pointer + index - start + 1, index + 1, preorder, end, inorder);

        return root;
    }

    //use stack to avoid pointer
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = preorder.length - 1; i >= 0; i--) {
            stack.push(preorder[i]);
        }

        TreeNode root = recurisveBuild(0, inorder.length - 1, inorder, stack);
        return root;
    }

    private static TreeNode recurisveBuild(int start, int end, int[] inorder, Deque<Integer> stack) {
        if (start > end) return null;
        while (!stack.isEmpty()) {
            Integer value = stack.pop();
            TreeNode root = new TreeNode(value);
            int index = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == value) {
                    index = i;
                    break;
                }
            }
            root.left = recurisveBuild(start, index - 1, inorder, stack);
            root.right = recurisveBuild(index + 1, end, inorder, stack);
            return root;
        }
        return null;
    }


}

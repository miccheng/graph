package com.example.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSideViewOfTree {
    public static void main(String args[]) {

    }

    //right view
   public static List<TreeNode> printRightView(TreeNode root ) {
       List<TreeNode> leftNodes = new ArrayList<>();
       if (root == null) return leftNodes;

       LinkedList<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       while (!queue.isEmpty()) {
           int size = queue.size();
           while (size > 0) {
               if (size == 1) leftNodes.add(queue.peek());
               TreeNode ele = queue.remove();
               if (ele.left != null) queue.add(ele.left);
               if (ele.right != null) queue.add(ele.right);
               size--;
           }
       }

       return leftNodes;
   }
   //works 2
//   while (!queue.isEmpty()) {
//        int size = queue.size();
//        for(int i=1;i<=size;i++){
//            if (i == 1) leftNodes.add(queue.peek().val);
//            TreeNode ele = queue.remove();
//            if (ele.right != null) queue.add(ele.right);
//            if (ele.left != null) queue.add(ele.left);
//        }
//    }
}

package com.example.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeftSideViewOfTree {
    public static void main(String args[]) {

    }

   public static List<TreeNode> printLeftView(TreeNode root ) {
       List<TreeNode> leftNodes = new ArrayList<>();
       if (root == null) return leftNodes;

       leftNodes.add(root);

       LinkedList<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       while (!queue.isEmpty()) {
           for (int i = 1; i < queue.size(); i++) {
               if (i == 1) leftNodes.add(queue.peek());
               TreeNode ele = queue.remove();
               if (ele.left != null) queue.add(ele.left);
               if (ele.right != null) queue.add(ele.right);
           }
       }

       return leftNodes;
   }
}

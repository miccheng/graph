package com.example.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSideViewOfTree {
    //right view
   public static List<TreeNode> printRightView(TreeNode root ) {
       List<TreeNode> result = new ArrayList<>();
       if (root == null) return result;

       LinkedList<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       while (!queue.isEmpty()) {
           int size = queue.size();
           for (int i = 0; i < size; i++) {
               TreeNode cur = queue.poll();
               if (i == 0) result.add(cur);
               if (cur.right != null) queue.offer(cur.right);
               if (cur.left != null) queue.offer(cur.left);
           }
       }

       return result;
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

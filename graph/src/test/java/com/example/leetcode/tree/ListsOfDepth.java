package com.example.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListsOfDepth {
    public List<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
       List<LinkedList<TreeNode>> lists=new ArrayList<LinkedList<TreeNode>>();
       createLinkedList(root,lists,0);
       return lists;
    }
    //depth first
    //a modification of pre-order traversal with level+1 recursive call
    public void createLinkedList(TreeNode root,List<LinkedList<TreeNode>> lists,int level) {
        if (root == null) return;
        LinkedList<TreeNode> list = null;
        if (lists.size() == level) {
            list = new LinkedList<TreeNode>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLinkedList(root.left, lists, level + 1);
        createLinkedList(root.right, lists, level + 1);
    }

    //breath first
   public List<LinkedList<TreeNode>> createLevelLinkedListB(TreeNode root) {
       List<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
       LinkedList<TreeNode> current = new LinkedList<TreeNode>();
       if (root != null) current.add(root);

       while (!current.isEmpty()) {
           result.add(current);//add current level
           LinkedList<TreeNode> parents = current;//go to next level
           current = new LinkedList<>();
           for (TreeNode node : parents) {
               if (node.left != null) current.add(node.left);
               if (node.right != null) current.add(node.right);
           }
       }

       return result;
   }

}

package com.example.leetcode.tree;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST {
/*  BST:the key in each node is greater than or equal to any key stored in the left sub-tree,
        and less than or equal to any key stored in the right sub-tree.

    Given an integer n, return the number of structurally unique BST's (binary search trees)
    which has exactly n nodes of unique values from 1 to n.
*/

    public static void main(String args[]){
        List<Integer> integers = Lists.newArrayList(1, 2, 3);
//        List<TreeNode> treeNodes = constructTree(integers);
        List<TreeNode> treeNodes = genTreeList(1, 3);
        int countTree = countTree(2, 3);
        System.out.println();
    }

    public static List<TreeNode> constructTree( List<Integer> list ) {
        List<TreeNode> roots = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TreeNode parentNode = new TreeNode(list.get(i));

            if (list.size() == 1) {
                roots.add(new TreeNode(list.get(0)));
                return roots;
            }

            int tail = list.size();
            List<TreeNode> leftNodes = new ArrayList<>();
            List<TreeNode> rightNodes = new ArrayList<>();
            //left
            if (i != 0) {
                leftNodes.addAll(constructTree(list.subList(0, i)));
            } else {
                leftNodes.add(null);
            }

            //right
            if (i+1 != tail) {
                rightNodes.addAll(constructTree(list.subList(i + 1, tail)));
            } else {
                rightNodes.add(null);
            }

            for (TreeNode node : leftNodes) {
                for (TreeNode node2 : rightNodes) {
                    parentNode.left = node;
                    parentNode.right = node2;
                    roots.add(parentNode);
                }
            }
        }
        return roots;
    }

    private static List<TreeNode> genTreeList(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (start > end) {
            list.add(null);
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> leftList = genTreeList(start, i - 1);
            List<TreeNode> rightList = genTreeList(i + 1, end);

            for (TreeNode left : leftList) {
                for(TreeNode right: rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }

    private static List<TreeNode> buildTreeList(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNode = buildTreeList(start, i - 1);
            List<TreeNode> rightNode = buildTreeList(i + 1, end);

            for (int j = 0; j < leftNode.size(); j++) {
                for (int k = 0; k < rightNode.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode.get(j);
                    root.right = rightNode.get(k);
                    list.add(root);
                }
            }
        }

        return list;
    }

    private static int countTree(int start, int end) {
        int total=0;
        if(end-start==0 || start >end){
            return 1;
        }

        for (int i = start; i <= end; i++) {
            int count=countTree(start, i-1)*countTree(i+1,end);
            total+=count;
        }
        return total;
    }

    public List<TreeNode> enumTrees(int start, int n) {
        List<TreeNode> result = Lists.newArrayList();
        //base case
        if (start > n) {
            result.add(null);
        }

        //body
        for (int i = start; i <= n; i++) {
            List<Integer> nums = new ArrayList<>();
            TreeNode current = new TreeNode(i);

            List<TreeNode> leftSub = enumTrees(start, i - 1);
            List<TreeNode> rightSub = enumTrees(i + 1, n);
            for (TreeNode left : leftSub) {
                for (TreeNode right : rightSub) {
                    current.right = right;
                    current.left = left;
                    result.add(current);
                }
            }
        }

        return result;
    }
}

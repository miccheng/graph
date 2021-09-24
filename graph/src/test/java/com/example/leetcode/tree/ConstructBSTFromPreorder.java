package com.example.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
//***similar: serialise and deserialise BST
//use queue to keep check the ele, or manage index manually
public class ConstructBSTFromPreorder {
    //Solution 1: moving index of the preorder[] is global
    private int start;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder==null||preorder.length==0) return null;
        start=0;
        return buildTree(preorder, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] preorder, Integer min, Integer max){
        if(start>=preorder.length) return null;
        if((min!=Integer.MIN_VALUE&&preorder[start]<=min) || (max!=Integer.MAX_VALUE&&preorder[start]>=max)) return null;
        TreeNode root=new TreeNode(preorder[start]);
        start++;
        root.left=buildTree(preorder,min, root.val);
        root.right=buildTree(preorder,root.val, max);
        return root;
    }

    //solution 2:
    public TreeNode deserialize(int preorder[]) {
        if (preorder == null || "".equals(preorder)) return null;
        LinkedList<Integer> queue = new LinkedList<>(Arrays.stream(preorder).boxed().collect(Collectors.toList()));
        return constructTree(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode constructTree(LinkedList<Integer> queue, int minValue, int maxValue) {
        if (queue.isEmpty()) return null;
        int rootVal = queue.peek();
        if ((minValue != Integer.MIN_VALUE && rootVal <= minValue) || (maxValue != Integer.MAX_VALUE && rootVal >= maxValue))
            return null;

        TreeNode root = new TreeNode(rootVal);
        queue.poll();
        root.left = constructTree(queue, minValue, rootVal);
        root.right = constructTree(queue, rootVal, maxValue);
        return root;
    }

}

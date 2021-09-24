package com.example.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;

        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                max=Math.max(max,cur.val);
                if(cur.left!=null)queue.add(cur.left);
                if(cur.right!=null)queue.add(cur.right);
            }
            result.add(max);
        }

        return result;
    }
}

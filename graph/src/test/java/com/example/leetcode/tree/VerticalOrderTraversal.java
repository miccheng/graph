package com.example.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;

        LinkedList<compositeNode> queue=new LinkedList<>();
        TreeMap<Integer, List<Integer>> groupMap=new TreeMap<>();//x coordinate->node.val

        queue.add(new compositeNode(root,0));


        while(!queue.isEmpty()){
            int size=queue.size();
            compositeNode cur=queue.poll();
            int xcoordinate=cur.xcoordinate;
            if(!groupMap.containsKey(xcoordinate)) groupMap.put(xcoordinate,new ArrayList<Integer>());
            groupMap.get(xcoordinate).add(cur.node.val);

            if(cur.node.left!=null) {
                queue.add(new compositeNode(cur.node.left,xcoordinate-1));
            }

            if(cur.node.right!=null){
                queue.add(new compositeNode(cur.node.right, xcoordinate+1));
            }
        }

        for(List<Integer> group: groupMap.values()){
            result.add(group);
        }

        return result;
    }


    class compositeNode{
        TreeNode node;
        int xcoordinate;
        public compositeNode(TreeNode node,int xcoordinate){
            this.xcoordinate=xcoordinate;
            this.node=node;
        }
    }
}

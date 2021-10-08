package com.example.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBST {
    //solution 2:
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result=new ArrayList<>();
        if(root1==null&&root2==null) return result;
        ArrayDeque<TreeNode> stack1=new ArrayDeque<>();
        ArrayDeque<TreeNode> stack2=new ArrayDeque<>();

        while(root1!=null||root2!=null||!stack1.isEmpty() || !stack2.isEmpty()){
            while(root1!=null){
                stack1.push(root1);
                root1=root1.left;
            }

            while(root2!=null){
                stack2.push(root2);
                root2=root2.left;
            }

            if(stack2.isEmpty()||!stack1.isEmpty()&&stack1.peek().val<stack2.peek().val){
                TreeNode par=stack1.pop();
                result.add(par.val);
                root1=par.right;
            }else{
                TreeNode par=stack2.pop();
                result.add(par.val);
                root2=par.right;
            }
        }
        return result;
    }
}

package com.example.leetcode.datastructure;

import com.example.leetcode.tree.TreeNode;

import java.util.ArrayDeque;

public class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if(s==null||s.length()==0) return null;
        int len=s.length();

        ArrayDeque<TreeNode> stack=new ArrayDeque<>();
        int i=0;
        int sign=1;
        while(i<len){
            char cur=s.charAt(i);
            int num=0;
            if(cur=='-'){
                sign=-1;
                i++;
            }else if(cur==')'){
                TreeNode current=stack.pop();
                TreeNode parent=stack.peek();
                if(parent.left==null){
                    parent.left=current;
                }else{
                    parent.right=current;
                }
                i++;
            } else if(cur=='('){
                i++;
            } else{
                while(i<len&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    num=num*10+s.charAt(i)-'0';
                    i++;
                }
                stack.push(new TreeNode((num)*sign));
                sign=1;
            }

        }
        return stack.peek();
    }
}

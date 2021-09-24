package com.example.leetcode.tree;

public class ConstructStringFromBinaryTree {

    //solution 1:
    public String tree2str(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb=new StringBuilder();
        recursive(root,sb);
        return sb.toString();
    }

    private void recursive(TreeNode root, StringBuilder sb){
        sb.append(root.val);
        if(root.left==null&&root.right==null) return;

        if(root.left!=null){
            sb.append("(");
            recursive(root.left,sb);
            sb.append(")");
        }

        if(root.right!=null){
            if(root.left==null) sb.append("()");
            sb.append("(");
            recursive(root.right,sb);
            sb.append(")");
        }
    }

    //solution2:
    public String tree2str2(TreeNode root) {
        if(root==null) return "";
        return dfs(root);
    }

    private String dfs(TreeNode root){
        if(root==null) return "";
        String left=dfs(root.left);
        String right=dfs(root.right);

        if(root.left!=null&&root.right!=null) return root.val+"("+left+")"+"("+ right+")";
        if(root.left!=null) return root.val+"("+left+")";
        if(root.right!=null) return root.val+"()"+"("+ right+")";
        return root.val+"";
    }
}

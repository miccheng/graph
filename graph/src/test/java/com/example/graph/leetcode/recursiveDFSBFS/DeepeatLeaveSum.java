package com.example.graph.leetcode.recursiveDFSBFS;

import com.example.leetcode.tree.TreeNode;

public class DeepeatLeaveSum {
    //Solution 1: DFS
    int sum=0;
    int max=0;

    public int deepestLeavesSum(TreeNode root) {
        recursive(root,0);
        return sum;

    }

    public void recursive(TreeNode root,int depth){
        if(root==null) return ;

        if(depth==max){
            sum+=root.val;
        }else if(depth>max){
            sum=root.val;
            max=depth;
        }
        recursive(root.left,depth+1);
        recursive(root.right, depth+1);
    }


//    Solution2: BFS
}

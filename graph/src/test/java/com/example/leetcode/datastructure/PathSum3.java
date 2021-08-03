package com.example.leetcode.datastructure;

import com.example.leetcode.tree.TreeNode;

import java.util.HashMap;

public class PathSum3 {
    //with time complexity O(NlogN->N^2)
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int i1 = countPath(root, targetSum);

        //path starting point from root left node && root right node
        int i2 = pathSum(root.left, targetSum);
        int i3 = pathSum(root.right, targetSum);
        return i1 + i2 + i3;
    }


    int countPath(TreeNode root, int targetSum) {
        int count = 0;
        if (root == null) return 0;
        if (targetSum - root.val == 0) count += 1;

        count += countPath(root.left, targetSum - root.val);
        count += countPath(root.right, targetSum - root.val);

        return count;
    }

    //O(N)
    public int pathSumMemorization(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();//val->count
        map.put(0,1);
        return pathSum2(root,0, targetSum,map);
    }

    private int pathSum2(TreeNode root, int runningSum, int targetSum, HashMap<Integer, Integer> map) {
        if (root == null) return 0;

        runningSum += root.val;
        int count = map.getOrDefault(runningSum - targetSum, 0);
        map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        count += pathSum2(root.left, runningSum, targetSum, map) + pathSum2(root.right, runningSum, targetSum, map);

        map.put(runningSum, map.get(runningSum) - 1);
        return count;
    }
}

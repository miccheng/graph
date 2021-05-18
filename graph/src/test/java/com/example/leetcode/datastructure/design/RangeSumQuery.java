package com.example.leetcode.datastructure.design;

//data structure: Segment tree
//pit : mid=int mid = root.start + (root.end - root.start) / 2 VS int mid=i+(j-i)/2;
public class RangeSumQuery {
    SegmentTreeNode root = null;

    //***partitioning the array
    public RangeSumQuery(int[] nums) {
        //build segment tree
        root=buildTree(nums,0,nums.length-1);
    }

    public void update(int index, int val) {
        updateTree(root, index,val);
    }

    public int sumRange(int left, int right) {
       return querySum(root, left, right);
    }

    private int querySum(SegmentTreeNode root, int i, int j) {
        if (root.end == j && root.start == i)
            return root.sum;

        int mid = root.start + (root.end - root.start) / 2;
        //wrong: int mid = (i + j) / 2;
        if (j <= mid)
            return querySum(root.left, i, j);
        else if (i > mid)
            return querySum(root.right, i, j);
        else
            return querySum(root.left, i, mid) + querySum(root.right, mid + 1, j);
    }



    private SegmentTreeNode buildTree(int[] nums, int i, int j) {
        if (i == j)
            return new SegmentTreeNode(i, j, nums[i], null, null);

        int mid = i + (j - i) / 2;//mid
        SegmentTreeNode left = buildTree(nums, i, mid);
        SegmentTreeNode right = buildTree(nums, mid + 1, j);
        return new SegmentTreeNode(i, j, left.sum + right.sum, left, right);
    }


    private void updateTree(SegmentTreeNode root, int index, int val) {
        //reach leaf node
        if (root.start == root.end && root.end == index) {
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;//mid
        if (index <= mid)
            updateTree(root.left, index, val);
        else
            updateTree(root.right, index, val);
        //***remember to update the sum of the updated node
        root.sum = root.left.sum + root.right.sum;
    }


    class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end, int sum, SegmentTreeNode left, SegmentTreeNode right) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }
    }
}

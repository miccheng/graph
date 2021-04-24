package com.example.leetcode.binarysearch.range;

import java.util.PriorityQueue;
//Given a set of numbers, divide the set into two sets such that there sum is equal.
public class FindKthInSorted2DMatrix {
//Given an n x n matrix where each of the rows and columns are sorted in ascending order,
// return the kth smallest element in the matrix.

    //solution 1: use heap
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> heap = new PriorityQueue<Tuple>();
        for (int j = 0; j < matrix[0].length; j++) {
            heap.add(new Tuple(matrix[0][j], 0, j));
        }

        for (int count = 0; count < k - 1; count++) {
            Tuple poll = heap.poll();
            int x = poll.row;
            int y = poll.column;
            if (x >= matrix.length) continue;//reach the bottom row
            heap.add(new Tuple(matrix[x + 1][y], x = 1, y));
        }
        return heap.remove().val;
    }

    //Solution 2 : *****Binary Search of space. --> find duplicate number
    public int kthSmallestB(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length][matrix[0].length];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countNum(mid, matrix);
            if (count < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private int countNum(int mid, int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            int j = matrix[0].length;
            while (j >= 0) {
                if (matrix[i][j] > mid) {
                    j--;
                    count += j + 1;
                }
            }
        }

        return count;
    }


    class Tuple implements Comparable<Tuple>{
        int val;
        int row;
        int column;

        public Tuple(int val, int row, int column) {
            this.val = val;
            this.row = row;
            this.column = column;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }

}

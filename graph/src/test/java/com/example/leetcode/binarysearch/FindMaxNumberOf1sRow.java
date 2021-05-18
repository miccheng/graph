package com.example.leetcode.binarysearch;

public class FindMaxNumberOf1sRow {
//given a matrix with millions of numbers in rows, containing only 1s and 0s. Find the row with max numbers of 1s.
    public int maxRow(int [][] matrix) {
        int row = 0;
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            int index = checkEachRow(matrix, i);
            int occurrences = matrix[0].length - index;
            if (occurrences != -1 && max < occurrences) {
                max = occurrences;
                row = i;
            }
        }
        return row;
    }

    public int checkEachRow(int [][]matrix, int i) {
        int left = 0;
        int right = matrix[0].length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[i][mid] == 1 && (matrix[i][mid - 1] == 0 || mid == 0))//***mid == 0
                return mid;
            else if (matrix[i][mid] == 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;//can't find it
    }
}

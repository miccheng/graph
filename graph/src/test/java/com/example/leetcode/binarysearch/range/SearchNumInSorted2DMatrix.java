package com.example.leetcode.binarysearch.range;

public class SearchNumInSorted2DMatrix {
//PLUS: 1d-->2d data structure,
// encoding (x,y)->Integer.Index=(x*column+y). Decode: x=Index/col, y=Index%col;

    //****Binary search in index:
    // matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = row * column - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            //mapping indices
            int midpointEle = matrix[mid / column][mid % column];
            if (target == midpointEle)
                return true;
            else if (target > midpointEle)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }

    //    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
    //    Output: true
    //****Binary search in space:
    public boolean searchMatrixII(int[][] matrix, int target) {
        //the key: start searching from the right top corner or left bottom corner
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int column = matrix[0].length;
        int j = column - 1;
        int i = 0;
        int start = matrix[i][j];

        while (i < matrix.length && j >= 0) {
            if (target == start)
                return true;
            else if (target > start)
                i++;
            else
                j--;
        }
        return false;
    }

}

package com.example.leetcode.diagram;

public class Toeplitz {
//    A Toeplitz matrix is a matrix where every left-to-right-descending diagonal has the same element. Given a non-empty matrix arr, write a function that returns true if and only if it is a Toeplitz matrix. The matrix can be any dimensions, not necessarily square
//    [[1,2,3,4],
//    [5,1,2,3],
//    [6,5,1,2]]
    static boolean isToeplitz(int[][] arr) {
        int row=arr.length;
        int column=arr[0].length;
        return checkDiagonal(arr,row, column );

    }

    private static boolean checkDiagonal(int[][] arr, int row, int column) {
        int i = 0;
        for (int j = 0; j < column - 1; j++) {
            int k = i + 1;
            int q = j + 1;

            while (k < row && q < column) {
                if (arr[i][j] != arr[k][q]) return false;
                k++;
                q++;
            }
        }
        return true;
    }
}

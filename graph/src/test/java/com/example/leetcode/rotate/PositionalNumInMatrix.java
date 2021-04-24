package com.example.leetcode.rotate;

public class PositionalNumInMatrix {
//find how many positional numbers
//Given a matrix of integers, task is to find out number of positional elements.
//A positional element is one which is either minimum or maximum in a row or in a column.

//Idea is to store the maximum and minimum of every row and column and then check for the required condition.
    public static int countPositional(int matrix[][], int m, int n) {
        int count=0;
        int[] rowMax=new int[m];
        int[] rowMini=new int[m];
        int[] columnMax=new int[n];
        int[] columnMini=new int[n];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                rowMax[i] = Math.max(rowMax[i], matrix[i][j]);
                rowMini[i] = Math.min(rowMini[i], matrix[i][j]);
            }
        }

        for (int j = 0; j <= n; j++) {
            for (int i = 0; i <= m; i++) {
                columnMax[j] = Math.max(columnMax[j], matrix[i][j]);
                columnMini[j] = Math.max(columnMini[j], matrix[i][j]);
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (matrix[i][j] == rowMax[i] ||
                        matrix[i][j] == rowMini[i] ||
                        matrix[i][j] == columnMax[j] ||
                        matrix[i][j] == columnMax[j])
                    count++;
            }
        }
        return count;
    }
}

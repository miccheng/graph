package com.example.leetcode.recursive.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        solveNQueens(4);
    }
    public static List<List<Integer>> solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        recurisve(0, n, new ArrayList<Integer>(), result);
        return result;
    }

    public static void recurisve(int row, int n, List<Integer> columns, List<List<Integer>> result) {
        if (columns.size()== n) {
            result.add(new ArrayList(columns));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (canPlace(row, col, columns)) {
                columns.add(col);
                recurisve(row + 1, n, columns, result);
                columns.remove(columns.size() - 1);
            }
        }

    }

    public static boolean canPlace(int row, int col, List<Integer> columns) {
        //check column
        for (Integer column : columns) {
            if (column == col) return false;
        }

        //check with any previous queen at diagonal
        for (int i = 0; i < row; i++) {
            int rowD = row - i;
            int colD = columns.get(i) - col;
            if (Math.abs(rowD) == Math.abs(colD)) return false;
        }

        return true;
    }
}

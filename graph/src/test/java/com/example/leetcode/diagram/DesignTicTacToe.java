package com.example.leetcode.diagram;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class DesignTicTacToe {
    public static void main(String[] args) {
        int[] nums1={2,4};
        int[] nums2={1,2,3,4};
    }

    int threshold;
    int rowCount[][];
    int colCount[][];
    int diagonal[];
    int anti_diagonal[];
    int turn = 0;

    /**
     * Initialize your data structure here.
     */
    public DesignTicTacToe(int n) {
        rowCount = new int[3][n];
        colCount = new int[3][n];
        diagonal = new int[3];
        anti_diagonal = new int[3];
        threshold = n;
    }

    public int move(int row, int col, int player) {
        rowCount[player][row]++;
        colCount[player][col]++;
        if (row == col) diagonal[player]++;
        if (row + col == threshold - 1) anti_diagonal[player]++;

        if (diagonal[player] == threshold || anti_diagonal[player] == threshold) return player;

        for (int i = 0; i < threshold; i++) {
            if (rowCount[player][i] == threshold || colCount[player][i] == threshold) return player;
        }

        return 0;
    }

}

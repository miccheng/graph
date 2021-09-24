package com.example.leetcode.diagram;

public class FindWinnerOnTicTacToe {
    public String tictactoe(int[][] moves) {
        int[][] row = new int[2][3];
        int[][] col = new int[2][3];
        int[] diagonal = new int[2];
        int[] anti_diagonal = new int[2];

        if (moves == null || moves.length == 0) return "";
        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0];
            int c = moves[i][1];
            int palyer = i % 2;//A

            row[palyer][r]++;
            col[palyer][c]++;
            if (r == c) diagonal[palyer]++;
            if (r + c == 2) anti_diagonal[palyer]++;

            if (row[palyer][0] == 3 || row[palyer][1] == 3 || row[palyer][2] == 3 ||
                    col[palyer][0] == 3 || col[palyer][1] == 3 || col[palyer][2] == 3 ||
                    diagonal[palyer] == 3 || anti_diagonal[palyer] == 3) return palyer == 0 ? "A" : "B";
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }
}

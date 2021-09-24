package com.example.leetcode.diagram;

public class ValidTicTacToe {
    public static void main(String[] args) {
        String [] board={"XXX","   ","OOO"};
        validTicTacToe(board);
    }

    public static boolean validTicTacToe(String[] board) {
        if (board == null || board.length == 0) return true;

        int row[][] = new int[2][3];
        int col[][] = new int[2][3];
        int diagonal[] = new int[2];
        int anti_diagonal[] = new int[2];

        int turn = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    row[0][i]++;
                    col[0][j]++;
                    if (i == j) diagonal[0]++;
                    if (i + j == 2) anti_diagonal[0]++;
                    turn++;
                } else {//"O"
                    row[1][i]++;
                    col[1][j]++;
                    if (i == j) diagonal[1]++;
                    if (i + j == 2) anti_diagonal[1]++;
                    turn--;
                }
            }
        }

        boolean awin = row[0][0] == 3 || row[0][1] == 3 || row[0][2] == 3 || col[0][0] == 3 || col[0][1] == 3 || col[0][2] == 3 || diagonal[0] == 3 || anti_diagonal[0] == 3;
        boolean bwin = row[1][0] == 3 || row[1][1] == 3 || row[1][2] == 3 || col[1][0] == 3 || col[1][1] == 3 || col[1][2] == 3 || diagonal[1] == 3 || anti_diagonal[1] == 3;

        //must discuss false first
        if ((awin && turn == 0) || (bwin && turn == 1) || turn > 1 || turn < 0) return false;
        return true;
    }
}

package com.example.leetcode.rotate;

import java.util.HashMap;
import java.util.Map;

public class FindWinnerOnTicTacToe {
    public static void main(String[] args) {
        int [][]matrix={{0,0},{2,0},{1,1},{2,1},{2,2}};
        tictactoe(matrix);
    }

    public static String tictactoe(int[][] moves) {
        int [] rowMap=new int[3];//col->count
        int [] colMap=new int[3];
        int diagonalMap=0;
        int rediagonalMap=0;

        for(int i=0;i<moves.length;i++){
            int row=moves[i][0];
            int col=moves[i][1];
            if(i%2==0){//
                rowMap[row]++;
                colMap[col]++;
                if(row==col)diagonalMap++;
                if(row+col==2)rediagonalMap++;
            }else{
                rowMap[row]--;
                colMap[col]--;
                if(row==col)diagonalMap--;
                if(row+col==2)rediagonalMap--;
            }
            if((rowMap[0]==3||rowMap[1]==3||rowMap[2]==3||colMap[0]==3||colMap[1]==3||colMap[2]==3||diagonalMap==3||rediagonalMap==3)&&i%2==0) return "A";
            if((rowMap[0]==-3||rowMap[1]==-3||rowMap[2]==-3||colMap[0]==-3||colMap[1]==-3||colMap[2]==-3||diagonalMap==-3||rediagonalMap==-3)&&i%2!=0) return "B";        }

        if(moves.length==9) return "Draw";

        return "Pending";
    }
}

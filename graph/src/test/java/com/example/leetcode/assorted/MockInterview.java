package com.example.leetcode.assorted;


import javax.xml.bind.SchemaOutputResolver;

/**
 * Part 1
 *
 * Connect Four is a game where two players take turns dropping colored discs into a 6 row x 7 column vertically suspended grid. The pieces fall straight down, occupying the lowest available space within the column. The objective of the game is to form horizontal or vertical of fours with the same colored discs.
 *
 *
 * Using a 2D Char array to represent the state of the grid (or another data structure, if you prefer),
 * Write a function to allow any player to drop a disc into a specified column. The function should return the location that was dropped and update the inputted board.
 *
 * e.g. dropDisc(board, column, color)
 *
 * Example:
 *
 *    0 1 2 3 4 5 6
 * 0 | | | | | | | |
 * 1 | | | | | | | |
 * 2 | | | | | | | |
 * 3 |R| | | | | | |
 * 4 |Y| | | | | | |
 * 5 |R| | |Y|Y|Y| |
 *   ---------------
 *
 * dropDisc(board, 4, 'R')
 * return: {4,4}
 * Board:
 *
 *    0 1 2 3 4 5 6
 * 0 | | | | | | | |
 * 1 | | | | | | | |
 * 2 | | | | | | | |
 * 3 |R| | | | | | |
 * 4 |Y| | | |R| | |
 * 5 |R| | |Y|Y|Y| |
 *   ---------------
 * Part 2
 *
 * Implement the functionality that determines if the user has won give a row and col. For our version of connect four, you can only win with horizontal or vertical 4 (or more) discs in a row.
 *
 * checkForWinner(board, 5, 5, 'Y')
 * return: true;
 *
 * checkForWinner(board, 5, 5, 'R')
 * return: false;
 *
 *    0 1 2 3 4 5 6
 * 0 | | | | | | | |
 * 1 | | | | | | | |
 * 2 | | | | | | | |
 * 3 |R| | | | | | |
 * 4 |Y| | | |R| | |
 * 5 |R| | |Y|Y|Y|Y|
 *   ---------------
 */

//   |Y| |R|R|R|R |R |Y | |

public class MockInterview {
    public static void main(String[] args) {
        int [][]board={{0,0,0,1},{0,0,0,1},{0,0,0,1},{0,0,1,1}};
        //**normal behavior
        Coordinate cordi=dropDisc(board,1, Colour.Y);
        //cord col, row
        System.out.println("row:"+cordi.getRow()+"column:"+cordi.getColumn());
        //board modified
        System.out.println(board[cordi.getRow()][cordi.getColumn()]==1);


        boolean result=checkWinner(board,cordi,1);
        System.out.println(result);

        //*** going upwards
        Coordinate cordi2=dropDisc(board,2, Colour.Y);
        //cord col, row
        System.out.println("row:"+cordi2.getRow()+"column:"+cordi2.getColumn());
        //board modified
        System.out.println(board[cordi2.getRow()][cordi2.getColumn()]==1);


        //** all places taken
        try{
        Coordinate cordi3=dropDisc(board,3, Colour.Y);
        //cord col, row
        System.out.println("row:"+cordi3.getRow()+"column:"+cordi3.getColumn());
        //board modified
        System.out.println(board[cordi3.getRow()][cordi3.getColumn()]==1);
        }catch (RuntimeException e){
            System.out.println("expected");
        }

        //invalid input

    }

//    public static int countConsecutiveColor( int [][] board, Coordinate cord, int dx, int dy, int color) {
//        for(int i = 1; i <= 4; ++i) {
//            if(board[cord.row + i*dy][cord.col + i*dx] != color) return (i-1);
//
//        }
//
//        return 4;
//    }
//
//    public static boolean checkWinnerWithDeltas(int [][] board, Cordinate cord, int color) {
//        if(countConsecutiveColor(board, cord, 1, 0, color) + countConsecutiveColor(board, cord, -1, 0, color) + 1 >= 4) {
//            // player has won
//        }
//        if(countConsecutiveColor(board, cord, 0, 1, color) + countConsecutiveColor(board, cord, -1, 0, color) + 1 >= 4) {
//            // player has won
//        }
//    }



    public static boolean checkWinner(int [][]board,  Coordinate cord, int colour) {
        int count = 0;
        int col=cord.getColumn();
        int row=cord.getRow();
//check row
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == colour) {
                count++;
            } else {
                count = 0;
            }
            if (count > 4) return true;
        }
//check column
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == colour) {
                count++;
            } else {
                count = 0;
            }
            if (count > 4) return true;
        }
        return false;
    }


    public static Coordinate dropDisc(int [][]board, int column, Colour color){
        //check input
       int rows= board.length;
        for (int i = rows-1; i >=0; i--) {
            if(board[i][column]==0){//2 taken R,1 taken Y, 0 vacant
                Coordinate loaction=new Coordinate(i, column);
                //enum value mapping
                switch (color){
                    case R:
                        board[i][column]=2;
                        break;
                    case Y:
                        board[i][column]=1;
                        break;
                }
                return loaction;
            }
        }
        //not able to place
        throw new RuntimeException("not enough space");
    }

    private static enum Colour {
        R,
        Y;
    }

    private static class Coordinate {
        //override toString
        int column;
        int row;
        public Coordinate(int row,int col){
            this.column = col;
            this.row = row;
        }
        //unnecessary
        public void setColumn(int col){
            this.column = col;
        }
        public void setRow(int row){
            this.row = row;
        }

        public int getColumn(){
            return column;
        }
        public int getRow(){
            return row;
        }
    }
}

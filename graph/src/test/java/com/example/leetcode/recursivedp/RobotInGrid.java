package com.example.leetcode.recursivedp;

import java.util.ArrayList;
import java.util.List;

public class RobotInGrid {
    public static void main(String[] args) {
        boolean maze[][] = {
                {true, true, true}, {true, false, true}, {true, true, true}
        };
        List<Point> path = new ArrayList<>();
        getPath(maze, 2, 2,path );
        System.out.println();
    }

    static boolean getPath(boolean maze[][], int row, int col, List<Point> path) {
        if (col < 0 || row < 0 || maze[row][col] == false) {
            return false;
        }
        if(row == 0 && col == 0){
            path.add(new Point(row,col));
            return true;
        }
        if (getPath(maze, row - 1, col, path) || getPath(maze, row, col - 1, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

    static class Point {
        int row;
        int col;

        Point(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }
}

package com.example.leetcode.graph;

public class NumberOfIslands {
    public static int[][] grids = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}
    };
    public static int row = grids.length;
    public static int column = grids[0].length;

    public static void main(String args[]) {
        int numberOfIslands = countNumberOfIslands();
        System.out.println(numberOfIslands);
    }

    private static int findNumberOfIslands() {
        int count = 0;
        int row = grids.length;
        for (int i = 0; i < row; i++) {
            int column = grids[0].length;
            for (int j = 0; j < column; j++) {
                int current = grids[i][j];
                if(current==1) {
                    count+=dfss(i,j);
                }
            }
        }
        return count;
    }

    private static int dfss(int i, int j) {
        //mark it
        grids[i][j] = '#';

        //base case
        if (grids[i][j] != 1 || i < 0 || i > row || j < 0 || j > column) return 0;

        //left, right,up , down
        dfss(i, j - 1);
        dfss(i, j + 1);
        dfss(i - 1, j);
        dfss(i + 1, j);
        return 1;
    }


    private static int countNumberOfIslands() {
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grids[i][j] == 0) continue;
                //dfs
                 dfs(i, j);
                 sum++;
            }
        }
        return sum;
    }

    private static void dfs(int i, int j) {
        //base case
        if (i < 0 || j < 0 || i >= grids.length || j >= grids[0].length || grids[i][j] == 0)
            return;

        //mark it as visited
        grids[i][j] = 0;
        //go 4 direction
        int up = i - 1;
        int down = i + 1;
        int left = j - 1;
        int right = j + 1;
            dfs(up, j);
            dfs(down, j);
            dfs(i, left);
            dfs(i, right);
    }
}

package com.example.graph.leetcode.recursiveDFSBFS;

public class IslandPerimeter {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    count = dfs(i, j, grid);
                    break;
                }
            }
        }
        return count;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 1;
        if (grid[i][j] == -1) return 0;

        grid[i][j] = -1;
        int boundary = 0;
        for (int[] dir : directions) {
            boundary += dfs(i + dir[0], j + dir[1], grid);
        }
        return boundary;
    }
}

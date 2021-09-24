package com.example.graph.leetcode.recursiveDFSBFS;

public class NumberOfProvince {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;
        int row = isConnected.length;
        int col = isConnected[0].length;

        int count = 0;
        for (int i = 0; i < row; i++) {
            if (isConnected[i][i] == 1) {
                dfs(i, isConnected);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, int grid[][]) {
        int n = grid.length;
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                grid[i][j] = -1;
                grid[j][i] = -1;
                dfs(j, grid);
            }
        }
    }
}

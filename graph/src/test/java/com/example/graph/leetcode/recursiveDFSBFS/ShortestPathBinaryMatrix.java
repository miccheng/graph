package com.example.graph.leetcode.recursiveDFSBFS;

import java.util.LinkedList;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int directions[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) return -1;

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean visited[][] = new boolean[row][col];
        visited[0][0] = true;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int r = top[0];
                int c = top[1];
                if (r == row - 1 && c == col - 1) return level + 1;

                for (int[] dir : directions) {
                    int nextRow = r + dir[0];
                    int nextCol = c + dir[1];
                    if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && grid[nextRow][nextCol] == 0 && visited[nextRow][nextCol] == false) {
                        visited[nextRow][nextCol] = true;
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }
            }
            level++;
        }

        return -1;
    }
}

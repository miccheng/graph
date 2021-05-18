package com.example.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        orangesRotting(grid);
    }

    public int orangesRottingComprehensive(int[][] grid) {
        if (grid.length == 0) return 0;
        int min = 0;

        Queue<rottenNode> que = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    que.add(new rottenNode(i, j, 0));
                }
            }
        }

        while (!que.isEmpty()) {
            rottenNode cur = que.remove();
            min = cur.min;

            if (cur.x > 0 && grid[cur.x - 1][cur.y] == 1) {
                grid[cur.x - 1][cur.y] = 2;
                que.add(new rottenNode(cur.x - 1, cur.y, cur.min + 1));
            }
            if (cur.x < grid.length - 1 && grid[cur.x + 1][cur.y] == 1) {
                grid[cur.x + 1][cur.y] = 2;
                que.add(new rottenNode(cur.x + 1, cur.y, cur.min + 1));
            }

            if (cur.y > 0 && grid[cur.x][cur.y - 1] == 1) {
                grid[cur.x][cur.y - 1] = 2;
                que.add(new rottenNode(cur.x, cur.y - 1, cur.min + 1));
            }
            if (cur.y < grid[0].length - 1 && grid[cur.x][cur.y + 1] == 1) {
                grid[cur.x][cur.y + 1] = 2;
                que.add(new rottenNode(cur.x, cur.y + 1, cur.min + 1));
            }

        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return min;
    }

    class rottenNode {
        int x, y;
        int min;

        public rottenNode(int x, int y, int min) {
            this.x = x;
            this.y = y;
            this.min = min;
        }
    }

    public static int orangesRotting(int[][] grid) {
        LinkedList<int[]> rotten = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) rotten.add(new int[]{i, j});
            }
        }
        int count = 0;
        while (!rotten.isEmpty()) {
            rotten = rotting(rotten, grid);
            if (rotten.isEmpty()) break;
            count++;
        }

        //last loop grid to see whether any fresh orange left
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return count;
    }

    private static LinkedList<int[]> rotting(LinkedList<int[]> rotten, int[][] grid) {
        LinkedList<int[]> temp = new LinkedList<>();
        int[] pop = rotten.pop();
        int i = pop[0];
        int j = pop[1];
        //go 4 directions
        if ((i - 1 >= 0) && grid[i - 1][j] == 1)
            grid[i - 1][j] = 2;
        temp.add(new int[]{i - 1, j});
        if ((i + 1 < grid.length) && grid[i + 1][j] == 1)
            grid[i + 1][j] = 2;
        temp.add(new int[]{i + 1, j});
        if ((j - 1 >= 0) && grid[i][j - 1] == 1)
            grid[i][j - 1] = 2;
        temp.add(new int[]{i, j - 1});
        if ((j + 1 < grid[0].length) && grid[i][j + 1] == 1)
            grid[i][j + 1] = 2;
        temp.add(new int[]{i, j + 1});

        return temp;
    }
}

package com.example.leetcode.graph;

//use tabulation to cache result
public class LongestIncreasingPathInMatrix {
    public static void main(String[] args) {
        int[][] grid = {{0}, {1}, {5}, {5}};
        int path = longestIncreasingPath(grid);
        System.out.println();
    }

    //raw version but with better performance
    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int maxPath = Integer.MIN_VALUE;
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] cache = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int currentVal = matrix[i][j];
                maxPath = Math.max(maxPath, dfs(i, j, matrix,cache));
            }
        }
        return maxPath;
    }

    private static int dfs(int i, int j, int[][] matrix,int[][] cache) {
        if(cache[i][j] != 0) return cache[i][j];

        int right = 0;
        int left = 0;
        int up = 0;
        int down = 0;
        int max=1;//***init with 1, and compare in the end

        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) left = 1 + dfs(i, j - 1, matrix,cache);
        if (j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1]) right = 1 + dfs(i, j + 1, matrix,cache);
        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) up = 1 + dfs(i - 1, j, matrix,cache);
        if (i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j]) down = 1 + dfs(i + 1, j, matrix,cache);
        //***must compare with max
        max=Math.max(Math.max(Math.max(left, right), Math.max(up, down)),max);

        cache[i][j] = max;
        return max;
    }

    //improved version
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPathImproved(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if(cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }


}

package com.example.leetcode.gridtraveller;

public class MinSumPath {
    //    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
//    Note: You can only move either down or right at any point in time.
    private static int arr[][] = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
    };

    private static int obstacleGrid[][] = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

    public static void main(String args[]) {

        uniquePaths(4,3);

        int i = minPathRecursive(arr.length -1, arr[0].length-1);
        System.out.println(i);

        //****iterative, bottom up
        int i3 = minPathRecursive2(0, 0);
        System.out.println(i3);

        int i2 = minPathTab(arr);
        System.out.println(i2);

        int ways = countWaysTab(3, 7);
        System.out.println(ways);

        int wayss = countWaysRecursive(3, 7);
        System.out.println(wayss);

        int obstacleWays = obstacleGridWays(3, 3);
        System.out.println(obstacleWays);
    }


    //pass in index
    private static int minPathRecursive(int m, int n) {
        if (m == 0 && n == 0) {
            return arr[0][0];
        }
        //when hit boundary row and boundary column
        if (m == 0 ) {
            return arr[m][n]+ minPathRecursive(m,n-1);
        }
        if (n == 0) {
            return arr[m][n] + minPathRecursive(m - 1, n);
        }
        int steps = arr[m][n] + Math.min(minPathRecursive(m - 1, n) , minPathRecursive(m, n - 1));
        return steps;
    }

    //backtracking
    private static int minPathRecursive2(int x, int y) {
        int m= arr.length;
        int n=arr[0].length;
        //when hit boundary row and boundary column
        if (x >m-1|| y > n-1) {
            return Integer.MAX_VALUE;
        }

        //base case
        if(x==n-1&&y==n-1){
         return arr[x][y];
        }
        int down=minPathRecursive2(x + 1, y);
        int right= minPathRecursive2(x, y + 1);

        int min=Math.min(down,right);
        int steps = arr[x][y] +min;
        return steps;
    }

    private static int minPathTab(int [][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 1; i < m; i++) {
            arr[i][0]+=arr[i-1][0];
        }
        for (int j = 1; j < n; j++) {
            arr[0][j]+=arr[0][j-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j]+=Math.min(arr[i][j - 1], arr[i - 1][j]);
            }
        }
        return arr[m-1][n-1];
    }
    

//    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//    How many possible unique paths are there?
    public static int countWaysTab(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int countWaysRecursive(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        if (m == 1) {
            return countWaysRecursive(m, n - 1);
        }
        if (n == 1) {
            return countWaysRecursive(m - 1, n);
        }

        int ways = countWaysRecursive(m - 1, n) + countWaysRecursive(m, n - 1);
        return ways;
    }


    public static int obstacleGridWays(int m, int n) {//1 means blocked
        int[][] dp = new int[m][n];
        dp[0][0]=1;
        for (int i = 1; i < m; i++) {
            int front = obstacleGrid[i - 1][0] > 0 ? 0 : 1;
            dp[i][0] = obstacleGrid[i][0] > 0 ? 0 : front;
        }
        for (int j = 1; j <n ; j++) {
            int up = obstacleGrid[0][j - 1] > 0 ? 0 : 1;
            dp[0][j] = obstacleGrid[0][j] > 0 ? 0 : up;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int up = obstacleGrid[i - 1][j] > 0 ? 0 : dp[i - 1][j];
                int left = obstacleGrid[i][j - 1] > 0 ? 0 : dp[i][j - 1];
                dp[i][j] = obstacleGrid[i][j] > 0 ? 0 : up + left;
            }
        }
        return dp[m-1][n-1];
    }

    // Improve from Dp to compress space
    public static int uniquePaths(int cols, int rows) {
        int[] cur = new int[cols];
        int[] pre = new int[cols];

        for (int i = 0; i < cols; i++) {
            pre[i] = 1;
            cur[i] = 1;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++)
                cur[j] = cur[j - 1] + pre[j];

            pre = cur;
        }

        return cur[cols - 1];
    }


}

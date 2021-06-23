package com.example.graph.leetcode.recursiveDFSBFS;

public class MaxAreaOfIsland {
    ////how to add up value in recursion
    int [][]dirs={{1,0},{-1,0},{0,1},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int max=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    int area=dfs(i,j,row, col, grid);
                    max=Math.max(max,area);
                }
            }
        }

        return max;
    }


    public int dfs(int i, int j,int row, int col,int[][] grid){
        if (i<0||i>=row||j<0||j>=col||grid[i][j]!=1) {return 0;}

        grid[i][j]=0;
        int area=1;
        for(int [] dir: dirs){
            area+= dfs(i+dir[0],j+dir[1], row, col, grid);
        }
        return area;
    }

}

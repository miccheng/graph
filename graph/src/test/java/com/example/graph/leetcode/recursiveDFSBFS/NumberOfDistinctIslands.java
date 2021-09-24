package com.example.graph.leetcode.recursiveDFSBFS;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        int [][]grid={{1,1,0},{0,1,1},{0,0,0},{1,1,1},{0,1,0}};
        numDistinctIslands(grid);
    }

    static int [][] directions={{1,0},{-1,0},{0,-1},{0,-1}};
    static Set<String> shape=new HashSet<>();
    static int count=0;

    public static int numDistinctIslands(int[][] grid) {
        if(grid==null||grid.length==0) return 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    StringBuilder strBuilder=new StringBuilder();
                    dfs(i, j, grid,strBuilder,"o");
                    if(shape.add(strBuilder.toString())) count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int i, int j, int[][] grid, StringBuilder strBuilder, String s){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!=1) {
            return ;
        }

        grid[i][j]=2;
        strBuilder.append(s);

        dfs(i+1,j, grid,strBuilder,"d");
        dfs(i-1,j, grid,strBuilder,"u");
        dfs(i,j+1, grid,strBuilder,"r");
        dfs(i,j-1, grid,strBuilder,"l");
        strBuilder.append("b");
    }
}

package com.example.leetcode.graph;

public class MaxGoldPath {
    public static int arr[][]={
//            {0,6,0},{5,8,7},{0,9,0}
            {1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}
    };
    public static int maxGold=0;
    public static void main(String args[]){
      maxGoldCollect(arr);
    }


    private static int maxGoldCollect(int[][] arr) {
        int sum=0;
        for (int i = 0; i < arr.length; i++) {//row
            for (int j = 0; j <arr[0].length; j++) {//column
                boolean flags[][]= new boolean[arr.length][arr[0].length];
                if(arr[i][j]==0){
                    continue;
                }
                dfs(i, j,sum);
            }
        }
        return maxGold;
    }

    private static void dfs(int i, int j,int sum) {
        //base case
        if (i < 0 || i > arr.length - 1 || j < 0 || j < arr[0].length || arr[i][j] == 0) {
            maxGold = Math.max(sum, maxGold);
            return;
        }
        sum += arr[i][j];
        //****mark visited
        arr[i][j]=0;
        dfs(i, j - 1, sum);
        dfs(i, j + 1, sum);
        dfs(i - 1, j, sum);
        dfs(i + 1, j, sum);
    }
    
    
}

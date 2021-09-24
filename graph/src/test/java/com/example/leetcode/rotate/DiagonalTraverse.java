package com.example.leetcode.rotate;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        if(mat==null||mat.length==0) return new int[0];

        int row=mat.length;
        int col=mat[0].length;
        int i=0;int j=0;


        int[] result=new int[row*col];


        for(int k=0;k<row*col;k++){
            result[k]=mat[i][j];

            if((i+j)%2==0){//upwards
                if(j==col-1){//
                    i++;
                }else if(i==0){
                    j++;
                }else {
                    i--;
                    j++;
                }
            }else{//downwards
                if(i==row-1){
                    j++;
                }else if(j==0){
                    i++;
                }else{
                    i++;
                    j--;
                }
            }
        }

        return result;
    }
}

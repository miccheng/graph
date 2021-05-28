package com.example.leetcode.rotate;

public class Rotate2DMatrix {
    public static void main(String args[]){
//        int arr[][]= {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };
        int arr[][]= {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(3,arr);
        rotate180(4,arr);
        //rotate(4, arr);
        System.out.println(arr);
    }
    //rotate +90 degree
    private static void rotate(int num, int[][] arr) {
        //transpose
        for (int i = 0; i < num; i++) {
            for (int j = i; j < num; j++) {
                int temp = arr[i][j];
                arr[i][j]=arr[j][j];
                arr[j][i]=temp;
            }
        }


        //flip left right
        int left=0;
        int right= arr[0].length-1;
        for (int i = 0; i < num; i++) {
            while (left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
            //reset
            left = 0;
            right = arr[0].length - 1;
        }

//        for (int i = 0; i < num; i++) {
//            for (int j = 0; j < num/2; j++) {
//                int temp = arr[i][j];
//                arr[i][j]=arr[i][num-1-j];
//                arr[i][num-1-j]=temp;
//            }
//        }

    }

    //rotate 180 degree
    private static void rotate180(int num, int[][] arr) {
        //flip up down
        for (int i = 0; i < num/2; i++) {
            for (int j = 0; j < num; j++) {
                int temp = arr[i][j];
                arr[i][j]=arr[num-i-1][j];
                arr[num-i-1][j]=temp;
            }
        }
        //flip left right
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <num/2 ; j++) {
                int temp = arr[i][j];
                arr[i][j]=arr[i][num-1-j];
                arr[i][num-1-j]=temp;
            }
        }
    }
}

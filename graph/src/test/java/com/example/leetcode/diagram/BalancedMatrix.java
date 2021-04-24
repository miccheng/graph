package com.example.leetcode.diagram;

public class BalancedMatrix {
    private static int[] row = new int[]{1,0,1,0};

    public static void main(String args[]){
        countMatrix(4);
    }

    private static void countMatrix(int n) {
        int [][]dp= new int[n][n];
    }

//    def count_0_1_matrices(n, still_needed=None):
//            if still_needed is None:
//              still_needed = [int(n/2) for _ in range(n)]

//            # Did we overrun any column?
//            for i in still_needed:
//            if i < 0:
//            return 0
//
//            # Did we reach the end of our matrix?
//            if 0 == sum(still_needed):
//            return 1
//
//            # Calculate the answer by recursion.
//            answer = 0
//            for row in possible_rows(n):
//                  next_still_needed = [still_needed[i] - row[i] for i in range(n)]
//                  answer = answer + count_0_1_matrices(n, next_still_needed)
//
//             return answer


}

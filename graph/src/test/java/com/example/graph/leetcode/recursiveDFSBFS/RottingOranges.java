package com.example.graph.leetcode.recursiveDFSBFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        if (grid == null | grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        int fresh = 0;
        boolean[][] visited = new boolean[row][col];
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (fresh == 0) return 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int top[] = queue.poll();
                for (int[] dir : directions) {
                    int nextRow = top[0] + dir[0];
                    int nextCol = top[1] + dir[1];
                    if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && grid[nextRow][nextCol] == 1 && visited[nextRow][nextCol] == false) {
                        visited[nextRow][nextCol] = true;
                        fresh--;
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }
            }
            count++;
        }

        return fresh == 0 ? count - 1 : -1;
    }


//    static boolean isMatch(String text, String pattern) {
//        if(text.length()==0&&pattern.length()==0) return true;
//        if(text==null||text.length()==0) return false;
//        if(pattern==null||pattern.length()==0) return false;
//        if(recursive(text, pattern, 0, 0)) return true;
//        return false;
//    }


//    private static boolean recursive(String text, String pattern, int i, int j){
//        if(i>=text.length()&&j>=pattern.length()) return true;
//        if(i>=text.length()||j>=pattern.length()) return false;
//
//        if(text.charAt(i)==pattern.charAt(j)||pattern.charAt(j)=='.'){
//            return recursive(text,pattern, i+1, j+1);
//        }else if(text.charAt(i)!=pattern.charAt(j)){
//            int lenP=pattern.length();
//            if(pattern.charAt(j)=='*'){
//                for(int q=i;q<text.length();q++){
//                    if(recursive(text, pattern, q,j)) return true;
//                }
//
//            }                  //"abbb", pattern = "ab*"
//            else if(j<lenP && pattern.charAt(j+1)=='*'){//acd ab*c.
//                return recursive(text,pattern, i, j+2);
//            }else{//acd ab, acd abc
//                return false;
//            }
//        }
//        return false;
//    }
}

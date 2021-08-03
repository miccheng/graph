package com.example.leetcode.binarysearch;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.TreeMap;

public class LeftmostColumnWithAtLeastOne {
    //Solution 1:simple binary search :frame the move mid condition carefully
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        if(binaryMatrix==null) return -1;
        List<Integer> matrix=binaryMatrix.dimensions();
        int row=matrix.get(0);
        int column=matrix.get(1);

        int colNum=Integer.MAX_VALUE;

        for(int i=0;i<row;i++) {
            int left = 0;
            int right = column - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (binaryMatrix.get(i, mid) == 0) {// must lie in the right side
                    left = mid + 1;
                } else {//could be itself or the right side
                    right = mid;
                }
            }
            //***could be all 0s or 1s
            if (binaryMatrix.get(i, left) == 1) colNum = Math.min(colNum, left);
        }

        return colNum==Integer.MAX_VALUE?-1:colNum;
    }

    //Solution 2:
    //as it is left most, we don't have the start searching 2nd row after the index found in row1
    public int leftMostColumnWithOneSpace(BinaryMatrix binaryMatrix) {
        if(binaryMatrix==null) return -1;
        List<Integer> matrix=binaryMatrix.dimensions();
        int row=matrix.get(0);
        int column=matrix.get(1);

        int colNum=Integer.MAX_VALUE;
        int i=0;
        int j=column-1;

        while(i<row&&j>=0){//start from top right
            int cur=binaryMatrix.get(i,j);
            if(cur==1){
                colNum=Math.min(colNum,j);
                j--;
            }else{
                i++;
            }
        }

        return colNum==Integer.MAX_VALUE?-1:colNum;
    }

    //interface
    class BinaryMatrix {
        public int get(int row, int col) {
            return 1;
        }
        public List<Integer> dimensions(){
            return Lists.newArrayList(1,2);
        }
    }
}

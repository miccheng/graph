package com.example.leetcode.twopointers.intervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int []> result=new ArrayList<>();
        if(firstList.length==0) return result.toArray(new int [0][0]);
        if(secondList.length==0) return result.toArray(new int [0][0]);

        int len1=firstList.length;
        int len2=secondList.length;


        int i=0;int j=0;
        while(i<len1&&j<len2){
            if(secondList[j][0]>firstList[i][1]){//no intersection
                i++;
            }else if(secondList[j][1]<firstList[i][0]){
                j++;
            }else{
                int start=Math.max(firstList[i][0],secondList[j][0]);
                int end=Math.min(firstList[i][1],secondList[j][1]);
                result.add(new int[]{start, end});
                if(end==firstList[i][1]){
                    secondList[j][0]=firstList[i][1]+1;
                    i++;
                }else{
                    firstList[i][0]=secondList[j][1]+1;
                    j++;
                }
            }
        }


        return result.toArray(new int [0][0]);
    }
}

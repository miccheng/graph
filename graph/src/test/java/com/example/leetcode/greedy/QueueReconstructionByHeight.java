package com.example.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int []a, int []b){
                if(a[0]==b[0]) return a[1]-b[1];
                return b[0]-a[0];
            }
        });

        List<int[]> result=new ArrayList<>();
        for(int current[]:people){
            result.add(current[1],current);
        }
        return result.toArray(new int[0][0]);
    }

}

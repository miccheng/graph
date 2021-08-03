package com.example.leetcode.recursivedp;

import java.util.Arrays;

public class LAlternatingSubsequence {
    //Solution 1: DP
    public int wiggleMaxLength(int[] nums) {
        if(nums==null|| nums.length==0) return 0;
        int len=nums.length;
        int dec[]=new int[len];
        int asc[]=new int[len];

        Arrays.fill(dec,1);
        Arrays.fill(asc,1);
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])asc[i]=Math.max(asc[i],dec[j]+1);
                if(nums[i]<nums[j])dec[i]=Math.max(dec[i],asc[j]+1);
            }
        }
        int max=0;
        for(int i=0;i<len;i++){
            max=Math.max(max, Math.max(dec[i],asc[i]));
        }

        return max;
    }


    //Solution 2: Counting peaks and valley
    public int wiggleMaxLengthGreedy(int[] nums) {
        if(nums==null|| nums.length==0) return 0;
        int len=nums.length;
        if(len==1) return len;

        int max=1;
        int prediff=0;
        for(int i=1;i<len;i++){
            int diff=nums[i]-nums[i-1];
            if(diff>0&&prediff<=0 ||diff<0&&prediff>=0){
                max++;
                prediff=diff;
            }
        }

        return max;
    }


}

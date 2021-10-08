package com.example.leetcode.slidingwindow;

public class MaxCard {
    public static void main(String[] args) {
        int [] nums={1,2,3,4,5,6,1};
        int k=3;
        maxScore(nums,k);
    }

    static int prefix=0;
    static int sum=0;
    static int max=0;
    public static int maxScore(int[] cardPoints, int k) {
        int len=cardPoints.length;

        for(int n:cardPoints ) sum+=n;

        int i=0; int j=i+len-k-1;
        for(int q=i;q<=j;q++){
            prefix+=cardPoints[q];
        }
        max=sum-prefix;
        while(j<len-1){
            prefix+=-cardPoints[i]+cardPoints[j+1];
            max=Math.max(max,sum-prefix);
            i++;
            j++;
        }

        return max;
    }
}

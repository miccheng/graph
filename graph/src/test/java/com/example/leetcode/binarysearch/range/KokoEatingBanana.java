package com.example.leetcode.binarysearch.range;

//find minimal(leftmost) of qualified -->return left
//cutting ribbons (maximal) of qualified -->return right
public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int max=findMax(piles);
        int left=1;
        int right=max;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(canEatAll(piles,mid, h)){//>=
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    private boolean canEatAll(int[] piles, int K, int H) {
        int countHour = 0; // Hours take to eat all bananas at speed K.

        for (int pile : piles) {
            countHour += pile / K;
            if (pile % K != 0)
                countHour++;
        }
        return countHour <= H;
    }

    private int findMax(int[] piles){
        int max=Integer.MIN_VALUE;
        for(int n: piles){
            max=Math.max(n,max);
        }
        return max;
    }
}

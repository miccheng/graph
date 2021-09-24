package com.example.leetcode.arraystr;

public class SortColors {
    public void sortColors(int[] nums) {
        if(nums==null||nums.length==0) return ;
        int len=nums.length;

        int p1=0;
        int p2=len-1;
        int i=0;

        while(i<=p2){
            int cur=nums[i];
            if(cur==0){
                swap(i,p1, nums);
                i++;
                p1++;
            }else if(cur==2){
                swap(i,p2, nums);
                p2--;
            }else{
                i++;
            }
        }
    }

    private void swap(int i, int j,int[] nums){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }


}

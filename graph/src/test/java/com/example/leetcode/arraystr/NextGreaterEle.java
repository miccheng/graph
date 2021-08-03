package com.example.leetcode.arraystr;

import java.util.*;

public class NextGreaterEle {
    public static void main(String[] args) {
        int []nums={1,2,3,4,3};
        nextGreaterElements(nums);
    }
    //I
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;

        int result[]=new int[len1];
        Map<Integer,Integer> map=new HashMap<>();
        Deque<Integer> stack=new ArrayDeque<>();

        for(int i=0;i<len2;i++){
            while(!stack.isEmpty()&&nums2[i]>stack.peek()){//***must be while rather than if
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }

        for(int i=0;i<len1;i++){
            int n=nums1[i];
            result[i]=map.getOrDefault(n,-1);
        }

        return result;
    }


    public static int[] nextGreaterElements(int[] nums) {
        int len=nums.length;
        int clone[]=new int[len*2];

        for (int i = 0; i < 2 * len; i++) {
            clone[i] = nums[i % len];
        }

        Deque<Integer> stack=new ArrayDeque<>();
        Map<Integer, Integer> map=new HashMap<>();
        int [] result=new int[len];

        for(int i=0;i<2*len;i++){
            while(!stack.isEmpty()&& clone[i]>clone[stack.peek()]){
                map.put(stack.pop(),i);
            }
            stack.push(i);
        }

        for(int i=0;i<len;i++){
            int index=map.getOrDefault(i,-1);
            result[i]=index==-1?index: clone[index];
        }

        return result;
    }
}

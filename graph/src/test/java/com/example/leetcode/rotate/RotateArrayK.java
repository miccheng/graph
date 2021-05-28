package com.example.leetcode.rotate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotateArrayK {
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//    nums = "----->-->"; k =3
//    result = "-->----->";
//
//    reverse "----->-->" we can get "<--<-----"
//    reverse "<--" we can get "--><-----"
//    reverse "<-----" we can get "-->----->"
    public static void main(String args[]){
        int nums [] = {1,2,3,4,5};
        int k = 3;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        rotLeft(list,2);
        rotate(nums,k);
        System.out.println();
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= nums.length;//*** when it's >len
        reverse(0, len - 1, nums);
        reverse(0, k-1, nums);
        reverse(k, len - 1, nums);
        ArrayList<Integer> list = new ArrayList<>();
    }

    private static void reverse(int left, int right,int[] nums) {
        while (left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        if(a==null||a.size()==0) return new ArrayList<Integer>();
        //reverse whole
        reverse(a,0, a.size()-1);

        //reverse (0, length-k -1)
        reverse(a,0, a.size()-1-d);

        //reverse (k+1,length-1)
        reverse(a, a.size()-1-d, a.size()-1);

        return a;
    }

    public static void reverse(List<Integer> a, int start, int end){
        if(a==null ||a.size()==0) return;
        while(start<end){
            int temp=a.get(start);
            int tail=a.get(end);
            a.set(start,tail);
            a.set(end,temp);
            start++;
            end--;
        }
    }



}





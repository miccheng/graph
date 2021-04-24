package com.example.leetcode.rotate;


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
        int nums [] = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
        System.out.println();
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= nums.length;//*** when it's >len
        reverse(0, len - 1, nums);
        reverse(0, k-1, nums);
        reverse(k, len - 1, nums);
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
}





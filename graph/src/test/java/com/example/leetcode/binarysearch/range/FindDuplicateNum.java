package com.example.leetcode.binarysearch.range;

//https://leetcode.com/problems/find-the-duplicate-number/
//Input: nums = [3,1,3,4,2]
//        Output: 3
public class FindDuplicateNum {
    //*****binary search of space
    //Idea: the frequency of the number must be <=the value of the number itself
    //Let's say n=10 and I select mid=5. Then I count all the numbers in the array which are less than equal mid. If the there are more than 5 numbers that are less than 5, then by Pigeonhole Principle (https://en.wikipedia.org/wiki/Pigeonhole_principle) one of them has occurred more than once. So I shrink the search space from [1 10] to [1 5]. Otherwise the duplicate number is in the second half so for the next step the search space would be [6 10].
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int n : nums) {
                if (n <= mid) count++;
            }
            if (count <= mid)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    //visualise the array into a graph/linkedlist cycle problem, and apply tortoise and hare floyd's cycle detection
    public int findDuplicateFloyd(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        while (true) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
            if (tortoise == hare) break;
        }

        //set either at the beginning
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        //return either
        return tortoise;
    }
}

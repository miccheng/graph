package com.example.leetcode.arraystr;

import java.util.*;

public class Sum3 {
    //lock down 1 ele and convert the problem to 2sum problem
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set=new HashSet<>();
        if(nums==null || nums.length==0) return new ArrayList<>(set);
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[j]+nums[k]+nums[i]>0){
                    k--;
                } else if(nums[j]+nums[k]+nums[i]<0){
                    j++;
                }else{
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
            }
        }
        return new ArrayList<>(set);
    }
//  Solution2
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int sum = 0 - nums[i];
                int p1 = i + 1;
                int p2 = len - 1;
                while (p1 < p2) {
                    if (nums[p1] + nums[p2] == sum) {
                        result.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                        while (p1 < p2 && nums[p1] == nums[p1 + 1]) {
                            p1++;
                        }
                        while (p1 < p2 && nums[p2] == nums[p2 - 1]) {
                            p2--;
                        }
                        p1++;
                        p2--;
                    } else if (nums[p1] + nums[p2] < sum) {
                        p1++;
                    } else {
                        p2--;
                    }
                }
            }
        }
        return result;
    }
}

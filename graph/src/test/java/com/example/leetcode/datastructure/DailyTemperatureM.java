package com.example.leetcode.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperatureM {

    public static void main(String[] args) {
        int arr[]={73,74,75,71,69,72,76,73};
        dailyTemperatures(arr);
    }
    //find next ele problem
    //Solution 1: monotonic stack
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }

    //solution 2: traverse array backwards
    //why has better performance?
    // with map, At index i, You have to iterate all the elements( from i+1 till the end) in the map to find the nearest higher temperature. Why is it more efficient than simply having a pointer j staring from i+1 and traversetill the end to find the nearest higher temperature?
    public int[] dailyTemperaturesHash(int[] temperatures) {
        int len=temperatures.length;
        int[] result= new int [len];


        Arrays.fill(result, Integer.MAX_VALUE);
        Map<Integer, Integer> map=new HashMap<>();//num-->index

        for(int i=len-1; i>=0;i--){
            for(Integer key:map.keySet()){
                if(key>temperatures[i]){
                    int j=map.get(key);
                    result[i]=Math.min(j-i,result[i]);
                }
            }
            if(result[i]==Integer.MAX_VALUE){result[i]=0;}
            map.put(temperatures[i],i);
        }

        return result;
    }
}

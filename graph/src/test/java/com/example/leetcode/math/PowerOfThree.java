package com.example.leetcode.greedy.math;

public class PowerOfThree {
    private static boolean power3v2(int num) {
        int i = 1;
        while (i < num) {
            i = i * 3;
        }
        return i == num;
    }

    private static boolean power3(int num) {
        //log MAX base 3==log MAX base e/ log3 base e
        int maxPow = (int) (Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) / Math.log(3))));
        return (num > 0 && maxPow % num == 0);
    }
}

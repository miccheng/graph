package com.example.leetcode.math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RomanNumberal {

    public String convert2RomanNum(String number) {
        List<String> digits = new ArrayList<>();
        int length = number.length();
        for (int i = 0; i < length; i++) {
            int digit = number.charAt(i) - '0';
            String digitStr = String.valueOf(digit);
            digits.add(digitStr);
        }
        //collectors join
        String str = digits.stream().collect(Collectors.joining());

        List<Integer> integers = new ArrayList<>();
        Integer integerNum = Integer.valueOf(number);
        for (int i = 0; i<length;i++) {
            int t = integerNum / 1000;
            integers.add(t);
            integerNum = integerNum % 1000;
        }

        int[] ints = number.chars().map(Character::getNumericValue).toArray();
        return str;
    }

}

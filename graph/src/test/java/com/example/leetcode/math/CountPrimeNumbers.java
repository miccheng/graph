package com.example.leetcode.math;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//run prime test
public class CountPrimeNumbers {
    public static void main(String args[]){
//        String s="HOW ARE YOU";
        String s="TO BE OR NOT TO BE";
        String test="  xyz ";
        printVertically(s);
    }

    public static List<String> printVertically(String s) {
        List<String> result = new ArrayList<>();
        String[] splitStr = s.split("\\s+");
        List<String> list = Lists.newArrayList(splitStr);
        //get the longest word
        String longest = list.stream().max(Comparator.comparing(e -> e.length())).get();
        int len = longest.length();
        int index = 0;

        for (; index < len; index++) {//index
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < splitStr.length; i++) {
                String str = " ";
                //check trailing
                if(index < splitStr[i].length()&& splitStr[i].charAt(index)==' '&& !str.isEmpty()){
                    //do nothing
                } else if (index < splitStr[i].length()) {
                    str = splitStr[i].charAt(index) + "";
                }
                builder.append(str);
            }
            result.add(builder.toString());
        }
        return result;
    }



    public int countPrimes(int n) {
        int count=0;
        for (int i = 0; i <= n; i++) {
            boolean flag=isPrime(i);
            if(flag) count++;
        }
        return count;
    }

    private boolean isPrime(int num) {
        if (num == 2 || num == 3) return true;
        else if (num == 1 || num % 2 == 0 || num % 3 == 0) return false;
        int divisor = 5;
        while (Math.pow(divisor, 2) <= num) {
            if (num % divisor == 0 || num % (divisor + 2) == 0) return false;
            divisor += 6;
        }
        return true;
    }
}

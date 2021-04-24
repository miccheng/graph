package com.example.leetcode.math;

import java.util.HashMap;

public class FractionRecurringDecimal {
    //****int -> promote to long
    public static void main(String args[]) {
        int numerator = -1;
        int denominator = -2147483648;
//        fractionToDecimalCopy(numerator,denominator);
        fractionToDecimal(numerator,denominator);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator==0) return "0";//***special case

        StringBuilder result=new StringBuilder();

        int sign=1;
        result.append((numerator<0 ^denominator<0)?"-":"");//negative result. same-->0, otherwise-->1
        long num=Math.abs((long) numerator);
        long den=Math.abs((long)denominator);

        long integral = num / den;

        result.append(String.valueOf(integral));
        long remainder=num%den;
        if(remainder==0) return result.toString();

        //continue
        result.append(".");
        int start=result.length();

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(remainder,start);

        while (remainder != 0) {
            remainder *=10;
            long digit = remainder / den;
            Integer index = map.get(remainder);
            if (index == null) {//no mapping for the key, value will be null
                result.append(digit);//String.valueOf(digit)
                map.put(remainder,start);
                start++;
            } else {//repeating
                result.insert(index, "(");
                result.append(")");
                break;
            }
            remainder %=den;
        }

        return result.toString();
    }

    public static String fractionToDecimalCopy(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            map.put(num, res.length());

            num *= 10;
            res.append(num / den);
            num %= den;

            Integer remainderIndex = map.get(num);
            if (remainderIndex != null) {
                res.insert(remainderIndex, "(");
                res.append(")");
                break;
            }
        }
        return res.toString();
    }
}

package com.example.leetcode.binarysearch;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == 0) return 0;

        int sign = (divisor < 0) ^ (dividend < 0) ? -1 : 1;

        //must convert to long and then abs.
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        long result = 0;
        while (ldividend >= ldivisor) {
            long tmp = ldivisor;
            long mul = 1;
            while (ldividend >= (tmp << 1)) {
                tmp <<= 1;
                mul <<= 1;
            }
            ldividend -= tmp;
            result += mul;
        }

        result *= sign;
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) result;
    }
}

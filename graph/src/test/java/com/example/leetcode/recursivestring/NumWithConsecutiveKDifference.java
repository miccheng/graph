package com.example.leetcode.recursivestring;

import java.util.ArrayList;
import java.util.List;

//***similar to PermutationVertical
public class NumWithConsecutiveKDifference {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        Integer num = null;
        //edge cases
        if (n == 0)
            return new int[0];
        if (n == 1)
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        recursive(num, n, k, result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void recursive(Integer num, int len, int k, List<Integer> result) {
        if (len == 0) {
            result.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (num == null && i == 0) continue;
            if (num == null && i != 0) {
                recursive(i, len - 1, k, result);
            } else if (i == num % 10 + k || i == num % 10 - k) {
                recursive(num * 10 + i, len - 1, k, result);//accumulate
            }
        }
    }

}

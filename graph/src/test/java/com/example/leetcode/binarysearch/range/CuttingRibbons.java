package com.example.leetcode.binarysearch.range;

//find maximal of qualified -->return right
public class CuttingRibbons {
    public int maxLength(int[] ribbons, int k) {
        int max = -1;
        for (int n : ribbons) {
            max = Math.max(max, n);
        }

        int left = 1;
        int right = max;
        while (left <= right) {
            int mid = left + (right -
                    left) / 2;
            if (cut(mid, ribbons) < k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right > 0 ? right : 0;
    }

    private int cut(int unit, int[] ribbons) {
        int result = 0;
        for (int n : ribbons) {
            result += n / unit;
        }
        return result;
    }
}

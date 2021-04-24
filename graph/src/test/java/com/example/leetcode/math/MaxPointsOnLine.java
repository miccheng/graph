package com.example.leetcode.math;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//TODO
public class MaxPointsOnLine {
    public static void main(String[] args) {
        int[][] input = {{1, 1}, {2, 2}, {3, 3}};
        int max = maxPoints(input);
        System.out.println();
    }

    public static int maxPoints(int[][] points) {
        int max = 0;
        int duplicate = 0;
        Map<Double, Integer> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int[] start_point = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] point = points[j];
                int deltax = point[0] - start_point[0];
                int deltay = point[1] - start_point[0];
                //duplicate
                if (deltax == 0 && deltay == 0) {
                    duplicate++;
                    continue;
                }
                double slope = calSlope(deltax, deltax);
                map.put(slope, map.getOrDefault(slope, 1) + 1);
            }
        }
        max = map.values().stream().reduce(Integer::max).get();
        return max;
    }

    private static double calSlope(int deltax, int deltay) {
        if (deltax == 0) return Integer.MAX_VALUE;
        if (deltay == 0) return 0;
        double slope = (deltay * 1.0) / deltax;
        return slope;
    }
}

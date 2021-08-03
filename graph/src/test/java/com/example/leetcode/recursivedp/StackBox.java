package com.example.leetcode.recursivedp;

import java.util.Arrays;

public class StackBox {
    //Must sort in two dimensional instead of 1
    public static int stackBox(int[][] boxes) {
        if (boxes == null || boxes.length == 0) return 0;
        Arrays.sort(boxes, (a, b) -> a[0] == b[0] ? (a[1] == b[1] ? b[2] - a[2] : b[1] - a[1]) : b[0] - a[0]);

        int len = boxes.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (boxes[j][0] < boxes[i][0] && boxes[j][1] < boxes[i][1] && boxes[j][2] < boxes[i][2])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int max = 1;
        for (int n : dp) {
            max = Math.max(n, max);
        }

        return max;
    }
}

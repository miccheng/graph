package com.example.leetcode.greedy.linkedlistpointers;

public class DistributeAroundCircle {
    //M items are to be delivered in a circle of size M.
    // Find the position where the M-th item will be delivered if we start from a given position K.
    public static void main(String args[]) {
        distributeItems(8, 5, 2);
    }

    private static int distributeItems(int m, int n, int k) {
        if (m < n) return k + m - 1;
        //left from the 1st circle
        m = m - (n - k) - 1;
        int pos = m % n == 0 ? n : m % n;
        return pos;
    }
}

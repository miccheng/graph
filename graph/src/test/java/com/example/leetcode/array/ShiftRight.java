package com.example.leetcode.array;

public class ShiftRight {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        shiftRight(array);
    }

    private static void shiftRight(int[] array) {
        int lastIndex = array.length - 1;
        int startNew = array[lastIndex];

        for (int i = lastIndex - 1; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = startNew;
    }
}

package com.example.leetcode.array;

// O(n) time and O(1) space
public class MaxRepeatingNumber {
    public static void main(String[] args) {
        //k=numbers of elements
        int arr[] = {2, 3, 3, 5, 3, 4, 1, 7};
        int k = 8;
    }

    //the max repeated number will be the index at which number at operated the most
    public static int maxRepeating(int arr[], int n, int k) {
        // Iterate though input array, for every element
        // arr[i], increment arr[arr[i]%k] by k
        for (int i = 0; i < n; i++)
            arr[(arr[i] % k)] += k;

        // Find index of the maximum repeating element
        int max = arr[0], result = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                result = i;
            }
        }

        /* Uncomment this code to get the original array back
        for (int i = 0; i< n; i++)
          arr[i] = arr[i]%k; */

        return result;
    }

}

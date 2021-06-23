package com.example.leetcode.recursive.knapsack;

//recursive:take or not===>swap or not ,all subset of a string(power set),scramble string
//dp table: row as the size of weights/profit, column will be from 0-capacity
//when not enough capacity, then grid result will be 0 as minimum.
public class Knapsack {
    static int value[] = {1, 6, 10, 16};
    static int weight[] = {1, 2, 3, 5};

    public static void main(String args[]) {
        int capacity = 7;
        int maxProfit = solveKnapsack(value, weight, 7);
        System.out.println(maxProfit);
    }

    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return knapsackRecursive(profits, weights, capacity, 0);
    }

    public int solveKnapsackTab(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length +1][capacity+1];
        return knapsackTab(dp, profits, weights, capacity);
    }

    private static int knapsackTopdown(int[] profits, int[] weights, int capacity, int index) {
        if (capacity <= 0 || index < 0) return 0;

        int profit = 0;

        //body
// If weight of the nth item is more than Knapsack capacity W,then this item cannot be included in the optimal solution
        int val = capacity - weight[index] > 0 ? profits[index] : 0;
        int leftCapacity = capacity - weight[index];
        int profit1 = val + knapsackTopdown(profits, weights, leftCapacity, index - 1);

        int profit2 = knapsackTopdown(profits, weights, capacity, index - 1);

        profit = Math.max(profit1, profit2);
        return profit;
    }


    private static int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        // base checks
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if (capacity >= weights[currentIndex])
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);

        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }

    //memorizing technique. an extension of recursive.
    private static int bestKnapsack(int capacity, int [] value) {
        int profit1 = 0;
        int profit2 = 0;
        if (value.length == 0) return 0;
        if (capacity < 0) return -1;

        for (int i = 0; i < value.length; i++) {
            int left = capacity - weight[i];
            int[] updateValues = new int[value.length - 1];
            System.arraycopy(weight, 1, updateValues, 0, value.length - 1);

            //take current
            int v = bestKnapsack(left, updateValues);
            if(v>=0) {
                profit1 += value[i];
            }
            //not taking
            int v2 = bestKnapsack(capacity, updateValues);
            profit2 = v2;
        }
        return Math.max(profit1, profit2);
    }

    //dp table: row as the size of weights/profit, column will be from 0-capacity
    //when not enough capacity, then grid result will be 0 as minimum.
    private int knapsackTab(Integer[][] dp, int[] profits, int[] weights, int capacity) {
//        Arrays.stream(dp).forEach(e->Arrays.fill(e,0));
        for (int j = 0; j <= weights.length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= capacity; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                int space = j - weights[i];
                int val = (space >= 0) ? (profits[i] + dp[i - 1][space]) : Integer.MIN_VALUE;
                dp[i][j] = Math.max(dp[i - 1][j], val);
            }
        }
        return dp[profits.length][capacity];
    }

}

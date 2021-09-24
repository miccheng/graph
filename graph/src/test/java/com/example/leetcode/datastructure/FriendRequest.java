package com.example.leetcode.datastructure;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FriendRequest {
    public static void main(String[] args) {
        int[] ages = {16, 16};
        numFriendRequests(ages);
    }

    //**range search: binary search and treemap
    public static int numFriendRequests(int[] ages) {
        if (ages == null || ages.length == 0) return 0;
        Arrays.sort(ages);
        int count = 0;

        TreeMap<Double, Integer> map = new TreeMap<>();//value--> index
        map.put(ages[0] * 1.0, 0);

        for (int i = 0; i < ages.length; i++) {
            int cur = ages[i];
            double target = 0.5 * cur + 7;
            //*** if lower bound is > upper bound
            if (target >= cur) continue;

            //lower bound
            Map.Entry<Double, Integer> entry = map.higherEntry(target);
            if (entry != null) {
                int index = entry.getValue();
                count += i - index;
            }
            //upper bound
            int j = i + 1;
            while (j < ages.length && ages[j] <= ages[i]) {
                j++;
            }
            count += j - i - 1;
            if (!map.containsKey(cur * 1.0)) map.put(cur * 1.0, i);
        }
        return count;
    }
}

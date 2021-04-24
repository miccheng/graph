package com.example.algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Algo {
    public static void main(String args[]) {

    }

    public static int findEuclidean(int n1, int n2){
        int min=Math.min(n1,n2);
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=min; i>=1; i--){
            if(n1%i==0&&n2==0){
                return i;
            }
        }
        return 1;
    }

    public static Integer bestAverageGrade(String[][] scores) {

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> frequence = new HashMap<>();
        for (int i = 0; i < scores.length; i++) {
            String name = scores[i][0];
            int score = Integer.valueOf(scores[i][1]);
            if (map.containsKey(name)) {
                int fre = frequence.get(name) + 1;
                frequence.put(name, fre);
            }
            int value = map.getOrDefault(name, 0);
            map.put(name, value + score);
        }
        Integer max = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();


        return 0;
    }


}
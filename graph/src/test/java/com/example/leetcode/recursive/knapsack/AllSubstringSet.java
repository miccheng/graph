package com.example.leetcode.recursive.knapsack;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Recursive:take or not ===> swap or not,choose or not.knapsack,scramble string
//Collecting result: collect all the edges along the branch. All construct word
//***palindrome partition problem
//**DIFF from all construct word: word bank is reusable, prefix has to match to be considered.
public class AllSubstringSet {
    static String input = "abcd";
    static String str[] = {"a", "b", "c"};


    //(abc-->[abc,ab,bc,ac,a,b,c,""]
    private static List<String> subsetAll(String str) {
        //base case
        if (str.length() == 0) return new ArrayList<>(Arrays.asList(""));

        //body
        List<String> resultList = new ArrayList<>();

        //take
        String current = String.valueOf(str.charAt(0));
        List<String> in = subsetAll(str.substring(0 + 1));
        List<String> updatedIn = in.stream().map(e -> e + current).collect(Collectors.toList());

        //not to take
        List<String> result2 = in;
        resultList.addAll(updatedIn);
        resultList.addAll(result2);
        return resultList;
    }

    // use i for base case, or length for base case
    // (abc-->[[abc],[ab],[bc],[ac],[a],[b],[c],[""]]
    private static void subsetAll2D(int i, List<String> path, List<List<String>> result) {
        List<List<String>> resultList = new ArrayList<>();
        if (i >= str.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        String current = str[i];
        List<String> withCurrentPath = new ArrayList<>(path);
        withCurrentPath.add(current);

        //not to take
        subsetAll2D(i + 1, path, result);
        subsetAll2D(i + 1, withCurrentPath, result);
    }


    //letter combination
    private static List<List<String>> getAllSubTab(String input) {
        List<List<String>> resultList = new ArrayList<>();
        List<String> startInner = Arrays.asList("");
        resultList.add(startInner);
        for (int i = 0; i < input.length(); i++) {
            int size = resultList.size();
            String current = String.valueOf(input.charAt(i));
            for (int j = 0; j < size; j++) {
                List<String> innerList = resultList.get(j);
                List<String> updatedList = innerList.stream().map(e -> e + current).collect(Collectors.toList());
                resultList.add(updatedList);
            }
        }
        return resultList;
    }
        


}

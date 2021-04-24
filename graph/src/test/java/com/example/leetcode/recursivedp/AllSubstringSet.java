package com.example.leetcode.recursivedp;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Recursive:take or not ===> swap or not,choose or not.knapsack,scramble string
//Collecting result: collect all the edges along the branch. All construct word
//***palindrome partition problem
//**DIFF from all construct word: word bank is reusable, prefix has to match to be considered.
public class AllSubstringSet {
    static String input = "abcd";
    static String str[] = {"a", "b", "c"};

    public static void main(String args[]) {
//        List<String> strings = Arrays.stream(split).collect(Collectors.toList());
//        List<List<String>> result = getAllSub(0);
//        getAllSubTab(input);
//        System.out.println(result);
//        List<String> comb = subsetAll("abc");
        List<String> list = subsetAll("abc");
        List<List<String>> lists = subsetAll2D(0);
        System.out.println(lists);
    }

    //(abc-->[abc,ab,bc,ac,a,b,c,""]
    private static List<String> subsetAll(String str) {
        //base case
        if (str.length() == 0) return new ArrayList<>(Arrays.asList(""));

        //body
        List<String> resultList = new ArrayList<>();
        //base cases

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

    //(abc-->[[abc],[ab],[bc],[ac],[a],[b],[c],[""]]
    private static List<List<String>> subsetAll2D(int index) {
        List<List<String>> resultList = new ArrayList<>();
        if (index >= str.length) {
            List<String> inner = Lists.newArrayList(Arrays.asList(""));
            resultList.add(inner);
            return resultList;
        }

        String current = str[index];
        List<List<String>> nest = subsetAll2D(index + 1);
        List<List<String>> notTake = Lists.newArrayList(nest);
        //not to take
        resultList.addAll(notTake);
        //take
        List<List<String>> take = new ArrayList<>();
        for (List<String> ele : nest) {
            List<String> collect = ele.stream().map(e -> e + current).collect(Collectors.toList());
            take.add(collect);
        }
        resultList.addAll(take);

        return resultList;
    }

    private static List<List<String>> getAllSub(int index) {
        if (index >=input.length()){
            List<String> inner=new ArrayList<>(Arrays.asList(""));
            List<List<String>> objects = Lists.newArrayList();
//            List<List<String>> listOLists = new ArrayList<>();
            objects.add(inner);
            return objects;
        }
        List<List<String>> resultList = new ArrayList<List<String>>();


        List<List<String>> sub = getAllSub(index + 1);
        //not to take
        List<List<String>> allSub = Lists.newArrayList(sub);

        //take
        String current = String.valueOf(input.charAt(index));
        for (int i = 0; i < sub.size(); i++) {
            if (!sub.isEmpty()) {
                List<String> ele = sub.get(i);
                List<String> collect = ele.stream().map(e -> e + current).collect(Collectors.toList());
                sub.set(i, collect);
            }
        }

        resultList.addAll(sub);
        resultList.addAll(allSub);

        return resultList;
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

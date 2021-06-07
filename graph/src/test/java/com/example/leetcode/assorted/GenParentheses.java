package com.example.leetcode.assorted;

import org.assertj.core.util.Lists;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class GenParentheses {
    public static void main(String[] args) {
        int n = 2;
        List <List<String>> result= Lists.newArrayList();
        List<String> input=Lists.newArrayList("1","2","3");
        combine(0,input, new ArrayList<String>(),result );

        List<List<String>> allCombinations = getAllCombinations(n);
        System.out.println(allCombinations.size());
    }

    public static List<List<String>> getAllCombinations( int pair){
        List<String> input=new ArrayList<String>();
        for(int i=0;i<pair;i++){
            input.add("(");
        }
        for(int i=0;i<pair;i++){
            input.add(")");
        }
        //ArrayDeque<String> path=new ArrayDeque<>();
        List <List<String>> result= Lists.newArrayList();

        combine(0,input, new ArrayList<String>(),result );

        //validate
       return validate(result);
    }

    public static void combine(int index,List<String> input,List<String> path,List <List<String>> result ){
        //base case
        if(index==input.size()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=index;i<input.size();i++){
            String current=input.get(i);
            path.add(current);
            combine(i+1,input, path, result);
            path.remove(path.size()-1);
        }

    }

    public static List <List<String>> validate(List <List<String>> result) {
        List<List<String>> validated = Lists.newArrayList();
        for (List<String> list : result) {
            ArrayDeque<String> stack = new ArrayDeque<>();
            for (String s : list) {
                if (s.equals("(")) {
                    stack.push("(");
                } else if (")".equals(stack.peek())) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) validated.add(list);
        }
        return validated;
    }
}

package com.example.leetcode.recursive.knapsack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParen {
//Solution 1--Choice/Selection type: observe the condition for inserting "(" and ")"

    public static List<String> generateParenthsis(int n){
        if(n<=0) return new ArrayList<String>();
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        recurisve(n,n,builder, result);
        return result;
    }

    private static void recurisve(int left, int right, StringBuilder builder, List<String> result) {
        if(left==right&&left==0){
            result.add(builder.toString());
            return;
        }

        StringBuilder b1=new StringBuilder(builder.toString());
        StringBuilder b2=new StringBuilder(builder.toString());

        if(left>0) {
            b1.append("(");
            recurisve(left - 1, right, b1, result);
        }

        if(right>0 && right>left) {
            b2.append(")");
            recurisve(left, right - 1, b2, result);
        }
    }

}

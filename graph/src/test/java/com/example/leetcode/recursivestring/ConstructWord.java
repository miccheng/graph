package com.example.leetcode.recursivestring;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConstructWord {
    public static void main(String args[]){
        String target="skateboard";
        String arr[][]= {{"sk","ska", "bo","board","te"}};

        String example="purple";
        String array[]={"purp","p","ur","le","purpl"};


//        List<List<String>> lists = allConstructTree(example, array);
//        System.out.println(lists);
        List<List<String>> result = allConstructTab(example, array);
        System.out.println(result);
//        String [][] result=new String[5][5];
//        System.arraycopy(arr,0,result,0,1);
//        System.arraycopy(array,0,result,1,1);
//        System.out.println(result);

//        int tabI = countConstructTab(example, array);
//        System.out.println(tabI);
//        int i = countConstructTree(example, array, new HashMap<String,Integer>());
//        System.out.println(i);
//        int i = "sk".length();
//        String remainder = target.substring(i,target.length());
//        String s = "sk".substring(2, 2);
//        System.out.println("".equals(s));
       // boolean b = canConstructTree(target, arr);
//        boolean tab = canConstructTab(target, arr);
//        System.out.println(tab);
    }

    private static boolean canConstructTree(String target,String arr[]) {
        if (target.equals("")) {
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (target.indexOf(arr[i]) == 0) {
                int startIndex = arr[i].length();
                String suffix = target.substring(startIndex, target.length());
                if (canConstructTree(suffix, arr) == true) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean canConstructTab(String target,String arr[]) {
        int n = target.length();
        boolean dp[] = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            if (dp[i] == true) {
                String remainder = target.substring(i, target.length());
                for (int j = 0; j < arr.length; j++) {
                    int index = remainder.indexOf(arr[j]);
//                    boolean b = target.substring(i, i + arr[j].length()).equals(arr[j]);
                    if (index == 0) {
                        dp[i + arr[j].length()] = true;
                    }
                }
            }
        }
        return dp[target.length()];
    }


    private static int countConstructTree(String target,String arr[], HashMap<String, Integer> map) {
        if(map.containsKey("target")){
            return map.get("target");
        }
        int sum = 0;
        if (target.equals("")) {
            return sum += 1;
        }
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (target.indexOf(s) == 0) {
                String suffix = target.substring(0 + s.length());
                int count = countConstructTree(suffix, arr,map);
                sum += count;
            }
        }
        map.put(target,sum);
        return sum;
    }

    private static int countConstructTab(String target,String arr[]) {
        int dp[] = new int[target.length() + 1];
        dp[0] = 1;
        for (int i = 0; i <= target.length(); i++) {//dp[]
            if (dp[i] > 0) {
                String suffix=target.substring(i);
                for (int j = 0; j < arr.length; j++) {//arr[]
                    int indicator = suffix.indexOf(arr[j]);
                    if (indicator == 0) {
                        int leap =arr[j].length();
                        dp[i+leap]=dp[i]+dp[i+leap];
                    }
                }
            }
        }
        return dp[target.length()];
    }

    private static List<List<String>> allConstructTree(String target, String arr[]) {
        List<List<String>> result = Lists.newArrayList(Lists.newArrayList());
        if ("".equals(target)) {
            List<List<String>> strings = new ArrayList<>();
            strings.add(Lists.newArrayList());
            return strings;
        }
        for (int i = 0; i < arr.length; i++) {
            if (target.indexOf(arr[i]) == 0) {
                String suffix = target.substring(arr[i].length());
                List<List<String>> strings = allConstructTree(suffix, arr);
                if (!strings.isEmpty()) strings.get(0).add(0, arr[i]);
                result.addAll(strings);
            }
        }
        System.out.println(result);
        return result;
    }


    private static List<List<String>> allConstructTab(String target, String arr[]) {
        Object [] dp=new Object[target.length()+1];
        dp[0] = new ArrayList<>(new ArrayList<String>());

        for (int i = 0; i <= target.length(); i++) {
            if (dp[i] != null) {
                for (int j = 0; j < arr.length; j++) {
                    int indicator = target.substring(i).indexOf(arr[j]);
                    if (indicator == 0) {
                        int leap = arr[j].length();
                        List<List<String>> o =(List<List<String>>) dp[i];
                        List<List<String>> objects = Lists.newArrayList();
                        if (o.isEmpty()) {
                            List<String> strings = Lists.newArrayList(arr[j]);
                            objects.add(strings);
                        } else {
                            objects.addAll(o);
                            for (List<String> obj : objects) {
                                obj.add(arr[j]);
                            }
                        }
                        if (dp[i + leap] == null) {
                            dp[i + leap]=objects;
                        } else {
                            ((List<List<String>>)dp[i + leap]).addAll(objects);
                        }
                    }
                }
            }
        }
        return (List<List<String>>)dp[target.length()];
    }
}

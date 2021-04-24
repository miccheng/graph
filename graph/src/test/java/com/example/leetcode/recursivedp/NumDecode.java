package com.example.leetcode.recursivedp;

import java.util.ArrayList;
import java.util.List;

public class NumDecode {
//    'A' -> "1"
//    'B' -> "2"
//      ...
//    'Z' -> "26"
//rob house
    public static void main(String args[]) {
        String[] mapping=new String[27];
        mapping['a'-'a'+1]="a";

        System.out.println(numDecodings("2134"));
//        numDecodings("26123");
        String input="21345";
        decodeWays(input);
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));//2nd previous
            int second = Integer.valueOf(s.substring(i - 2, i));//previous
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static int numDecoding(String s) {
        if(s.length()==0)
            return 0;

        int dp[]=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i < s.length(); i++) {
            Integer value = Integer.valueOf(s.charAt(i-1));
            Integer value2 = Integer.valueOf(s.substring(i - 2, i));
            if (0 < value &&value <= 9) {
                dp[i ] += dp[i-1];
            }
            if(value2>10&& value2<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }

    //result list might needs to be List<List<String>>
    public static List<String> decodeRecursive( String str, int i) {
        List<String> list = new ArrayList<>();
        //base case
        if ("".equals(str)) return list;

        //body: combine with previous or stand alone
        int end = str.length() - 1;
        String substring1 = str.charAt(i) + "";
        String substring2 = str.substring(end - 1);

        String suffix1 = str.substring(0, end - 1);
        List<String> list1 = decodeRecursive(suffix1, suffix1.length() - 1);
        list1.add(substring1);

        List<String> list2 = new ArrayList<>();
        if (Integer.valueOf(substring2) <= 26 && Integer.valueOf(substring2) >= 0) {
            String suffix2 = str.substring(0, end - 2);
            list2 = decodeRecursive(suffix2, suffix2.length() - 1);
            list2.add(substring2);
        }
        list.addAll(list1);
        list.addAll(list2);

        //add both result to list
        return list;
    }

    private static int decodeWays(String input) {
        int previous = input.charAt(0) - '0' == 0 ? 0 : 1;
        int secPrevious = 1;
        int result = 0;

        for (int i = 1; i < input.length(); i++) {
            int c = input.charAt(i);
            //separate
            if (c - '0' == 0) {
                previous = 0;
            }
            result+=previous;

            //combine with previous
            String substring = input.substring(i - 1, i + 1);
            Integer integer = Integer.valueOf(substring);
            if (integer > 26) {
                secPrevious = 0;
            }
            result+=secPrevious;

            secPrevious = previous;
            previous = result;
        }

        return result;
    }



}

package com.example.graph.leetcode.recursiveDFSBFS;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    public static void main(String[] args) {
        numDecodingsDp("1102");
    }
    public int numDecodings(String s) {
        if( s==null||s.length()==0) return 0;

        return recursive(s, new HashMap<String, Integer>());
    }


    public int recursive(String s, Map<String, Integer> map ) {
        if (s.length() == 0) return 1;

        int count = 0;
        for (int i = 1; i <= 2; i++) {
            if (s.length() >= i) {
                String pefix = s.substring(0, i);
                int current = Integer.valueOf(pefix);
                if (!pefix.startsWith("0") && current > 0 && current <= 26) {
                    String remain = s.substring(i);
                    if (map.get(remain) != null) {
                        count += map.get(remain);
                    } else {
                        count += recursive(remain, map);
                        map.put(remain, count);
                    }
                }
            }
        }
        return count;
    }

    public static int numDecodingsDp(String s) {
        if( s==null||s.length()==0) return 0;
        if (s.startsWith("0")) return 0;
        int len=s.length();

        int dp[]=new int[len+1];
        dp[0]=1;
        dp[1]=Character.getNumericValue(s.charAt(0))==0?0:1;

        for(int i=2;i<=len;i++){
            int first=Integer.valueOf(s.substring(i-1,i));
            int second=Integer.valueOf(s.substring(i-2,i));

            if(first>0 &&first<=9){
                dp[i]+=dp[i-1];
            }
            if(second>=10&&second<=26){
                dp[i]+=dp[i-2];
            }
        }


        return dp[len];
    }

}

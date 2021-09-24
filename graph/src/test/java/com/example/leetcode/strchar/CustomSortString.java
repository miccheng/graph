package com.example.leetcode.strchar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomSortString {

    public String customSortString(String order, String s) {
        if(s==null||s.length()==0) return "";
        int len=order.length();

        int count[]=new int[26];
        for(char c: s.toCharArray()){
            count[c-'a']++;
        }

        String result="";
        for(int i=0;i<order.length();i++){//go through alphbet
            while(count[order.charAt(i)-'a']!=0){
                result+=order.charAt(i);
                count[order.charAt(i)-'a']--;
            }
        }

        for(int i=0;i<count.length;i++){
            while(count[i]!=0){
                result+=(char)(i+'a');
                count[i]--;
            }
        }
        return result;
    }


}

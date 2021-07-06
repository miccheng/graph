package com.example.leetcode.recursivestring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParen {

    //Solution 2--Sub problems: (), insert right next to every ( with ()
    public List<String> generateParenthesis(int n) {
        if(n<=0) return new ArrayList<String>();

        Set<String> s= recursive(n);
        return new ArrayList<String>(s);
    }

    public Set<String> recursive(int n){
        Set<String> result=new HashSet<>();
        if(n==0){
            result.add("");
            return result;
        }

        Set<String> pre=recursive(n-1);

        for(String res: pre){
            insertParn(res, result);
            result.add("()"+res);
        }

        return result;
    }

    public void insertParn(String res,Set<String> result ){
        int len=res.length();
        for(int i=0; i<len; i++){
            if(res.charAt(i)=='('){
                result.add(res.substring(0,i+1) +"()"+res.substring(i+1));
            }
        }
    }

}

package com.example.leetcode.arraystr;

public class StrRotation {
    //***whether there is a way to split s1=xy and s2=yx.
    //regardeless where the split point is, yx will always be a substring of xyxy.
    //-->NextGreaterEleII problem
    boolean isRotation(String s1,String s2) {
        return (s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);
    }

}

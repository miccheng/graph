package com.example.leetcode.arraystr;

public class AddBoldTagInString {

    public String addBoldTag(String s, String[] words) {
        int len=s.length();
        boolean[] bold=new boolean[len];

        for(String word: words){
            int start=0;
            while(start>=0){
                start=s.indexOf(word,start);
                if(start<0) break;
                for(int i=start;i<start+word.length();i++){
                    bold[i]=true;
                }
                start++;
            }
        }

        StringBuilder build=new StringBuilder();
        for(int i=0;i<len;i++){
            if(bold[i]==false){
                build.append(s.charAt(i));
            }else{
                int j=i;
                while(j<len&&bold[j]){
                    j++;
                }
                build.append("<b>"+s.substring(i,j)+"</b>");
                i=j-1;
            }
        }
        return build.toString();
    }
}

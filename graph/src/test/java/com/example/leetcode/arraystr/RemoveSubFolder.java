package com.example.leetcode.arraystr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RemoveSubFolder {
    public static void main(String[] args) {
        String folder[] = {"/a/b/c","/a/b/ca","/a/b/d"};
        removeSubfolders(folder);
    }

    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        int len=folder.length;
        LinkedList<String> result=new LinkedList<>();

        for(int i=0;i<len;i++){
            String cur=folder[i];
            //ensure it is a parent
            if(!result.isEmpty()&&cur.startsWith(result.peekLast()+"/")) continue;
            result.add(cur);
        }
        return result;
    }
}

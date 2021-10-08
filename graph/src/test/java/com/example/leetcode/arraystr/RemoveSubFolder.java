package com.example.leetcode.arraystr;

import java.util.*;

public class RemoveSubFolder {
    public static void main(String[] args) {
        String folder[] = {"/a","/a/b/c","/a/b/d"};
        removeSubfolders(folder);
    }

//    public static List<String> removeSubfolders(String[] folder) {
//        Arrays.sort(folder);
//        int len=folder.length;
//        LinkedList<String> result=new LinkedList<>();
//
//        for(int i=0;i<len;i++){
//            String cur=folder[i];
//            //ensure it is a parent
//            if(!result.isEmpty()&&cur.startsWith(result.peekLast()+"/")) continue;
//            result.add(cur);
//        }
//        return result;
//    }


    static class TrieNode {
        boolean end;
        Map<String, TrieNode> nodes;
        public TrieNode() {
            this.end = false;
            this.nodes = new HashMap<>();;
        }
    }

    public static List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode();
        for (String str : folder) {
            String[] names = str.split("/");
            TrieNode cur = root;
            for (String name : names) {
                Map<String, TrieNode> map = cur.nodes;
                if (!map.containsKey(name)) {
                    map.put(name, new TrieNode());
                }
                cur = map.get(name);
            }
            cur.end = true;
        }

        List<String> ans = new LinkedList<>();
        for (String str : folder) {
            String[] names = str.split("/");
            TrieNode cur = root;
            boolean flag = false;
            for (int i = 0; i < names.length; i ++) {
                TrieNode node = cur.nodes.get(names[i]);
                if (node.end && i < names.length - 1) {
                    flag = true;
                    break;
                }
                cur = node;
            }
            if (!flag) ans.add(str);
        }

        return ans;
    }
}

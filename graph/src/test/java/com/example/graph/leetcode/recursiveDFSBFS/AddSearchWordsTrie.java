package com.example.graph.leetcode.recursiveDFSBFS;

public class AddSearchWordsTrie {
    Node root;

    public AddSearchWordsTrie() {
        root=new Node('\0');
    }

    public void addWord(String word) {
        Node current=root;
        for(char c:word.toCharArray()){
            if(current.children[c-'a']==null) current.children[c-'a']=new Node(c);
            current=current.children[c-'a'];
        }
        current.endOfWord=true;
    }

    public boolean search(String word) {
        char chars[]=word.toCharArray();
        return getNode(chars,0,root);
    }

    private boolean getNode(char chars[], int start, Node beg) {
        if (start == chars.length) return beg.endOfWord;

        char cur = chars[start];
        if (cur == '.') {
            for (Node child : beg.children) {
                if (child != null) {
                    if (getNode(chars, start + 1, child) == true) return true;
                }
            }
            return false;
        } else {
            if (beg.children[cur - 'a'] == null) return false;
            return getNode(chars, start + 1, beg.children[cur - 'a']);
        }
    }



    class Node{
        char c;
        Node children[]=new Node[26];
        boolean endOfWord;

        Node(char c){
            this.c=c;
        }
    }
}

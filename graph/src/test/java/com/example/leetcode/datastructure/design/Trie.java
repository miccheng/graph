package com.example.leetcode.datastructure.design;

//*** AKA, prefix tree
public class Trie {
    private Node root;

    public Trie() {
        root = new Node('\0');
    }

    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {//****must check before append
                current.children[c - 'a'] = new Node(c);
            }
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        Node node = getNode(word, root,0);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        Node node = getNode(prefix, root, 0);
        return node != null;
    }

    private Node getNode(String s,Node root, int start){
        if(start==s.length()) return root;
        if(root.children[s.charAt(start)-'a']==null) return null;
        return getNode(s,root.children[s.charAt(start)-'a'],start+1);
    }

    class Node {
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node(char c) {
            this.c = c;
            this.isWord = false;
            this.children = new Node[26];
        }
    }

}

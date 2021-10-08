package com.example.graph.leetcode.recursiveDFSBFS;

import org.assertj.core.util.Lists;

import java.util.*;

public class AccountMerge {
    public static void main(String[] args) {
        List<List<String>> accounts=Lists.newArrayList(Lists.newArrayList("John", "0", "1"),Lists.newArrayList("John","0","2"),Lists.newArrayList("Mary","mary@mail.com"),Lists.newArrayList("John","johnnybravo@mail.com"));
        Lists.newArrayList(new int[]{1,2});
        accountsMergeDFS(accounts);
    }

    //Solution 1: DFS
    public static List<List<String>> accountsMergeDFS(List<List<String>> accounts) {
        List<List<String>> result= new ArrayList<>();
        if(accounts==null||accounts.size()==0) return result;

        Map<String, List<String>> graph=new HashMap<>();
        Map<String, String> userMap=new HashMap<>();

        for(List<String> current: accounts){
            String name=current.get(0);
            for(int i=1;i<current.size();i++){
                graph.putIfAbsent(current.get(i), new ArrayList<String>());

                userMap.put(current.get(i),name);

                if(i==1) continue;

                graph.get(current.get(i)).add(current.get(i-1));
                graph.get(current.get(i-1)).add(current.get(i));
            }
        }

        Set<String> visited=new HashSet<>();
        for(String email: graph.keySet()){
            if(visited.contains(email)) continue;
            //collected all the connected vertices
            List<String> connectedEmails=new ArrayList<>();
            dfs(email, graph,connectedEmails, visited);

            Collections.sort(connectedEmails);
            connectedEmails.add(0,userMap.get(email));
            result.add(connectedEmails);
        }

        return result;

    }

    public static void dfs(String cur, Map<String, List<String>> graph, List<String> connectedEmails, Set<String> visisted){
        connectedEmails.add(cur);

        List<String> neighbors=graph.get(cur);
        for(String nghb:neighbors){
            if(visisted.add(nghb)){
                dfs(nghb,graph,connectedEmails,visisted);
            }
        }
    }

        //Solution 2: union find
    public static List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        //union
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), p);
        }

        for(List<String> a : acts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }

    private static String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}

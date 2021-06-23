package com.example.leetcode.recursivestring;
import java.util.ArrayList;
import java.util.List;

public class PermutationVertical {
    public void permutation(List<String> l) {
        permutation(l, "");
    }

    public void permutation(List<String> l, String prefix) {
        if (l.isEmpty()) {
            System.out.println(prefix);
        } else {
            String s = l.remove(0);
            for (int i = 0; i < s.length(); i++) {
                permutation(new ArrayList<String>(l), prefix + s.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        Object[] nums=new Object[1];
        int length = nums.length;

        List<String> l = new ArrayList();
        l.add("MORGAN");
        l.add("STANLY");
        l.add("INVESTMENT");
        l.add("BANK");

        PermutationVertical d = new PermutationVertical();
        d.permutation(l);
    }
}

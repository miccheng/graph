package com.example.leetcode.arraystr;

public class OneEditAway {
    public boolean oneEditAway(String s1, String s2) {
        if (s1.length() == s2.length())
            return oneReplace(s1, s2);
        else if (Math.abs(s1.length() - s2.length()) == 1)
            return oneInsertRemove(s1, s2);
        else
            return false;
    }

    private boolean oneInsertRemove(String s1, String s2) {
        String longer = s1.length() > s2.length() ? s1 : s2;
        String shorter = s1.length() > s2.length() ? s2 : s1;
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < longer.length() && j < shorter.length()) {
            if (longer.charAt(i) != shorter.charAt(i)) {
                count++;
                i++;
            } else {
                i++;
                j++;
            }
        }
        return count > 1;
    }


    private boolean oneReplace(String s1, String s2) {
        int len = s1.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
            if (count > 1) return false;
        }
        return true;
    }
}

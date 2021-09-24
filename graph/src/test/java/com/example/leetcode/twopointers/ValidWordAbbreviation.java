package com.example.leetcode.twopointers;

public class ValidWordAbbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        return dfs(0, 0, word, abbr);
    }

    private static boolean dfs(int i, int j, String word, String abbr) {
        if (i == word.length() && j == abbr.length()) return true;
        if (i == word.length() || j == abbr.length()) return false;

        if (word.charAt(i) != abbr.charAt(j))
            return false;
        else if (Character.isLetter(abbr.charAt(j))) {
            return dfs(i + 1, j + 1, word, abbr);
        } else {
            int count = 0;
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                if (count == 0 && abbr.charAt(j) - '0' == 0) return false;//"a" "01"
                count = count * 10 + abbr.charAt(j) - '0';
                j++;
            }
            return dfs(i + count, j, word, abbr);
        }
    }
}

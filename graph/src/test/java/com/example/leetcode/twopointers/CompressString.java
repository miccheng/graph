package com.example.leetcode.twopointers;

public class CompressString {
    public static void main(String args[]){
//      Map<Character, Integer> collect = map.entrySet().stream().filter(a -> a.getValue().intValue() != 1).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
//        char input[] = {'c','c','c','a','a','b','b'};
        char input[] = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        compressH(input);
    }
    public static int compressH(char[] chars) {
        int i = 0;
        int j = 1;
        int index = 0;
        while (i < chars.length) {
            if (j < chars.length && chars[i] == chars[j]) {
                j++;
            } else {
                int count = j - i;
                chars[index++] = chars[i];
                char[] digit = (count + "").toCharArray();
                if (count > 1) {
                    for (char c : digit) {
                        chars[index++] = c;
                    }
                }
                i = j;
            }

        }
        return index;
    }

    public static int compress(char[] chars) {
        int index = 0;
        int i = 0;
        for (; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    j++;
                } else if (j - i > 1) {
                    String repeat=j-i +"";
                    char[] digits = repeat.toCharArray();
                    for (int k = 0; k <repeat.length() ; k++) {
                        chars[index++]=digits[k];
                    }
                    i=j;
                }
            }
        }
        return index;
    }

    public static int compressStr(char[] chars) {
        int index = 0;
        int i = 0;
        for (; i < chars.length; i++) {
            int j = i;
            char lockedChar = chars[i];
            while (j < chars.length && lockedChar == chars[j]) {
                j++;
            }

            int repeated = j - i;
            if (j - i > 1) {
                String repeat = repeated + "";
                for (int k = 0; k < repeat.length(); k++) {
                    chars[index++] = repeat.toCharArray()[k];
                }
            }
            i = j;
        }

        return index;
    }

    public static int compressString(char[] chars) {
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int j = i;
            while (j < chars.length && chars[j] == c) {
                j++;
            }
            String frequency = j - i + "";

            if (Integer.valueOf(frequency) > 1) {
                for (char x : frequency.toCharArray()) {
                    chars[index++] = x;
                }
            }
            i=j;
        }

        return index;
    }

}


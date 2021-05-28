package com.example.leetcode.arraystr;

public class URLify {
    public static void main(String[] args) {
        char[] str = {'b', ' ', 'a', ' ', ' '};
        int len = 3;
        replaceSpace(str, len);
    }

    //*assumption: The length of original str is enough to hold the result string after modification
    public static void replaceSpace(char[] str, int trueLength) {
        int countSpace = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') countSpace++;
        }

        int finalLen = trueLength + countSpace * 2;
        if (trueLength < str.length) str[finalLen] = '\0';//***substring the original str by adding an end
        int index = finalLen - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index] = '0';
                str[index - 1] = '2';
                str[index - 2] = '%';
                index -= 3;
            } else {
                str[index] = str[i];
                index--;
            }

        }

        System.out.println();
    }
}
